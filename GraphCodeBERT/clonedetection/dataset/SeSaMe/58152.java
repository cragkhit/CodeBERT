int writeMethodParametersAttr ( MethodSymbol m ) {
    MethodType ty = m.externalType ( types ).asMethodType();
    final int allparams = ty.argtypes.size();
    if ( m.params != null && allparams != 0 ) {
        final int attrIndex = writeAttr ( names.MethodParameters );
        databuf.appendByte ( allparams );
        for ( VarSymbol s : m.extraParams ) {
            final int flags =
                ( ( int ) s.flags() & ( FINAL | SYNTHETIC | MANDATED ) ) |
                ( ( int ) m.flags() & SYNTHETIC );
            databuf.appendChar ( pool.put ( s.name ) );
            databuf.appendChar ( flags );
        }
        for ( VarSymbol s : m.params ) {
            final int flags =
                ( ( int ) s.flags() & ( FINAL | SYNTHETIC | MANDATED ) ) |
                ( ( int ) m.flags() & SYNTHETIC );
            databuf.appendChar ( pool.put ( s.name ) );
            databuf.appendChar ( flags );
        }
        for ( VarSymbol s : m.capturedLocals ) {
            final int flags =
                ( ( int ) s.flags() & ( FINAL | SYNTHETIC | MANDATED ) ) |
                ( ( int ) m.flags() & SYNTHETIC );
            databuf.appendChar ( pool.put ( s.name ) );
            databuf.appendChar ( flags );
        }
        endAttr ( attrIndex );
        return 1;
    } else {
        return 0;
    }
}
