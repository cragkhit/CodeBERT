static void copy ( final WindowsPath source,
                   final WindowsPath target,
                   CopyOption... options )
throws IOException {
    boolean replaceExisting = false;
    boolean copyAttributes = false;
    boolean followLinks = true;
    boolean interruptible = false;
    for ( CopyOption option : options ) {
        if ( option == StandardCopyOption.REPLACE_EXISTING ) {
            replaceExisting = true;
            continue;
        }
        if ( option == LinkOption.NOFOLLOW_LINKS ) {
            followLinks = false;
            continue;
        }
        if ( option == StandardCopyOption.COPY_ATTRIBUTES ) {
            copyAttributes = true;
            continue;
        }
        if ( ExtendedOptions.INTERRUPTIBLE.matches ( option ) ) {
            interruptible = true;
            continue;
        }
        if ( option == null ) {
            throw new NullPointerException();
        }
        throw new UnsupportedOperationException ( "Unsupported copy option" );
    }
    SecurityManager sm = System.getSecurityManager();
    if ( sm != null ) {
        source.checkRead();
        target.checkWrite();
    }
    WindowsFileAttributes sourceAttrs = null;
    WindowsFileAttributes targetAttrs = null;
    long sourceHandle = 0L;
    try {
        sourceHandle = source.openForReadAttributeAccess ( followLinks );
    } catch ( WindowsException x ) {
        x.rethrowAsIOException ( source );
    }
    try {
        try {
            sourceAttrs = WindowsFileAttributes.readAttributes ( sourceHandle );
        } catch ( WindowsException x ) {
            x.rethrowAsIOException ( source );
        }
        long targetHandle = 0L;
        try {
            targetHandle = target.openForReadAttributeAccess ( false );
            try {
                targetAttrs = WindowsFileAttributes.readAttributes ( targetHandle );
                if ( WindowsFileAttributes.isSameFile ( sourceAttrs, targetAttrs ) ) {
                    return;
                }
                if ( !replaceExisting ) {
                    throw new FileAlreadyExistsException (
                        target.getPathForExceptionMessage() );
                }
            } finally {
                CloseHandle ( targetHandle );
            }
        } catch ( WindowsException x ) {
        }
    } finally {
        CloseHandle ( sourceHandle );
    }
    if ( sm != null && sourceAttrs.isSymbolicLink() ) {
        sm.checkPermission ( new LinkPermission ( "symbolic" ) );
    }
    final String sourcePath = asWin32Path ( source );
    final String targetPath = asWin32Path ( target );
    if ( targetAttrs != null ) {
        try {
            if ( targetAttrs.isDirectory() || targetAttrs.isDirectoryLink() ) {
                RemoveDirectory ( targetPath );
            } else {
                DeleteFile ( targetPath );
            }
        } catch ( WindowsException x ) {
            if ( targetAttrs.isDirectory() ) {
                if ( x.lastError() == ERROR_DIR_NOT_EMPTY ||
                        x.lastError() == ERROR_ALREADY_EXISTS ) {
                    throw new DirectoryNotEmptyException (
                        target.getPathForExceptionMessage() );
                }
            }
            x.rethrowAsIOException ( target );
        }
    }
    if ( !sourceAttrs.isDirectory() && !sourceAttrs.isDirectoryLink() ) {
        final int flags = ( !followLinks ) ? COPY_FILE_COPY_SYMLINK : 0;
        if ( interruptible ) {
            Cancellable copyTask = new Cancellable() {
                @Override
                public int cancelValue() {
                    return 1;  
                }
                @Override
                public void implRun() throws IOException {
                    try {
                        CopyFileEx ( sourcePath, targetPath, flags,
                                     addressToPollForCancel() );
                    } catch ( WindowsException x ) {
                        x.rethrowAsIOException ( source, target );
                    }
                }
            };
            try {
                Cancellable.runInterruptibly ( copyTask );
            } catch ( ExecutionException e ) {
                Throwable t = e.getCause();
                if ( t instanceof IOException ) {
                    throw ( IOException ) t;
                }
                throw new IOException ( t );
            }
        } else {
            try {
                CopyFileEx ( sourcePath, targetPath, flags, 0L );
            } catch ( WindowsException x ) {
                x.rethrowAsIOException ( source, target );
            }
        }
        if ( copyAttributes ) {
            try {
                copySecurityAttributes ( source, target, followLinks );
            } catch ( IOException x ) {
            }
        }
        return;
    }
    try {
        if ( sourceAttrs.isDirectory() ) {
            CreateDirectory ( targetPath, 0L );
        } else {
            String linkTarget = WindowsLinkSupport.readLink ( source );
            int flags = SYMBOLIC_LINK_FLAG_DIRECTORY;
            CreateSymbolicLink ( targetPath,
                                 WindowsPath.addPrefixIfNeeded ( linkTarget ),
                                 flags );
        }
    } catch ( WindowsException x ) {
        x.rethrowAsIOException ( target );
    }
    if ( copyAttributes ) {
        WindowsFileAttributeViews.Dos view =
            WindowsFileAttributeViews.createDosView ( target, false );
        try {
            view.setAttributes ( sourceAttrs );
        } catch ( IOException x ) {
            if ( sourceAttrs.isDirectory() ) {
                try {
                    RemoveDirectory ( targetPath );
                } catch ( WindowsException ignore ) { }
            }
        }
        try {
            copySecurityAttributes ( source, target, followLinks );
        } catch ( IOException ignore ) { }
    }
}
