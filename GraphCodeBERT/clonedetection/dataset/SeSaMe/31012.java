boolean impliesIgnoreMask ( FilePermission that ) {
    if ( FilePermCompat.nb ) {
        if ( this == that ) {
            return true;
        }
        if ( allFiles ) {
            return true;
        }
        if ( this.invalid || that.invalid ) {
            return false;
        }
        if ( that.allFiles ) {
            return false;
        }
        if ( ( this.recursive && that.recursive ) != that.recursive
                || ( this.directory && that.directory ) != that.directory ) {
            return false;
        }
        if ( this.npath.equals ( that.npath )
                && this.directory == that.directory ) {
            return true;
        }
        int diff = containsPath ( this.npath, that.npath );
        if ( diff >= 1 && recursive ) {
            return true;
        }
        if ( diff == 1 && directory && !that.directory ) {
            return true;
        }
        if ( this.npath2 != null ) {
            if ( this.npath2.equals ( that.npath )
                    && this.directory == that.directory ) {
                return true;
            }
            diff = containsPath ( this.npath2, that.npath );
            if ( diff >= 1 && recursive ) {
                return true;
            }
            if ( diff == 1 && directory && !that.directory ) {
                return true;
            }
        }
        return false;
    } else {
        if ( this.directory ) {
            if ( this.recursive ) {
                if ( that.directory ) {
                    return ( that.cpath.length() >= this.cpath.length() ) &&
                           that.cpath.startsWith ( this.cpath );
                } else {
                    return ( ( that.cpath.length() > this.cpath.length() ) &&
                             that.cpath.startsWith ( this.cpath ) );
                }
            } else {
                if ( that.directory ) {
                    if ( that.recursive ) {
                        return false;
                    } else {
                        return ( this.cpath.equals ( that.cpath ) );
                    }
                } else {
                    int last = that.cpath.lastIndexOf ( File.separatorChar );
                    if ( last == -1 ) {
                        return false;
                    } else {
                        return ( this.cpath.length() == ( last + 1 ) ) &&
                               this.cpath.regionMatches ( 0, that.cpath, 0, last + 1 );
                    }
                }
            }
        } else if ( that.directory ) {
            return false;
        } else {
            return ( this.cpath.equals ( that.cpath ) );
        }
    }
}
