public TypeBinding reportError ( BlockScope scope ) {
    if ( this.binding instanceof ProblemFieldBinding ) {
        scope.problemReporter().invalidField ( this, ( FieldBinding ) this.binding );
    } else if ( this.binding instanceof ProblemReferenceBinding || this.binding instanceof MissingTypeBinding ) {
        scope.problemReporter().invalidType ( this, ( TypeBinding ) this.binding );
    } else {
        scope.problemReporter().unresolvableReference ( this, this.binding );
    }
    return null;
}
