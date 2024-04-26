public void setKeyword ( ModuleModifierKeyword modifierKeyord ) {
    if ( modifierKeyord == null ) {
        throw new IllegalArgumentException();
    }
    preValueChange ( KEYWORD_PROPERTY );
    this.modifierKeyword = modifierKeyord;
    postValueChange ( KEYWORD_PROPERTY );
}
