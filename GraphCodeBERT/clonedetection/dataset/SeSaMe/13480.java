public void setLabel ( SimpleName label ) {
    if ( label == null ) {
        throw new IllegalArgumentException();
    }
    ASTNode oldChild = this.labelName;
    preReplaceChild ( oldChild, label, LABEL_PROPERTY );
    this.labelName = label;
    postReplaceChild ( oldChild, label, LABEL_PROPERTY );
}
