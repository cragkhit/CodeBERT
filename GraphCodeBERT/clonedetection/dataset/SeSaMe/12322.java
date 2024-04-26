public static TypeBinding moreDangerousType ( TypeBinding one, TypeBinding two ) {
    if ( one == null ) {
        return null;
    }
    long oneNullBits = validNullTagBits ( one.tagBits );
    long twoNullBits = validNullTagBits ( two.tagBits );
    if ( oneNullBits != twoNullBits ) {
        if ( oneNullBits == TagBits.AnnotationNullable ) {
            return one;    
        }
        if ( twoNullBits == TagBits.AnnotationNullable ) {
            return two;    
        }
        if ( oneNullBits == 0 ) {
            return one;    
        }
        return two;				
    } else if ( one != two ) { 
        if ( analyse ( one, two, -1 ).isAnyMismatch() ) {
            return two;    
        }
    }
    return one;
}
