public void setModel ( TreeModel model ) {
    clear();
    this.model = ( model != null ) ? model : new TreeModel();
    model.setTree ( this );
    initTree ( model.getRoot() );
}
