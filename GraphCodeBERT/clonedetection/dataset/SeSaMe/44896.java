@BeanProperty ( description
                = "Sets the component that the tooltip describes." )
public void setComponent ( JComponent c ) {
    JComponent oldValue = this.component;
    component = c;
    firePropertyChange ( "component", oldValue, c );
}
