public UnsignedInteger dividedBy ( UnsignedInteger val ) {
    return fromIntBits ( UnsignedInts.divide ( value, checkNotNull ( val ).value ) );
}
