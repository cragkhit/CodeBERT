public ColorSelectionModel getColorSelectionModel() {
    return ( this.chooser != null )
           ? this.chooser.getSelectionModel()
           : null;
}
