protected Color getColorFromModel() {
    ColorSelectionModel model = getColorSelectionModel();
    return ( model != null )
           ? model.getSelectedColor()
           : null;
}
