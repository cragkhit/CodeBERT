public void collectSubstitutes ( TypeBinding otherType, Map substitutes ) {
    if ( otherType.isArrayType() ) {
        int otherDim = otherType.dimensions();
        if ( otherDim == this.dimensions ) {
            this.leafComponentType.collectSubstitutes ( otherType.leafComponentType(), substitutes );
        } else if ( otherDim > this.dimensions ) {
            ArrayBinding otherReducedType = this.environment.createArrayType ( otherType.leafComponentType(), otherDim - this.dimensions );
            this.leafComponentType.collectSubstitutes ( otherReducedType, substitutes );
        }
    }
}
