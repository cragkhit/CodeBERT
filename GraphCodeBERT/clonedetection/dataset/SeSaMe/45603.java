@BeanProperty ( description
                = "The tabbedpane's SingleSelectionModel." )
public void setModel ( SingleSelectionModel model ) {
    SingleSelectionModel oldModel = getModel();
    if ( oldModel != null ) {
        oldModel.removeChangeListener ( changeListener );
        changeListener = null;
    }
    this.model = model;
    if ( model != null ) {
        changeListener = createChangeListener();
        model.addChangeListener ( changeListener );
    }
    firePropertyChange ( "model", oldModel, model );
    repaint();
}
