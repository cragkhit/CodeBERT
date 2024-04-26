public Component getComponent() {
    if ( fList == null ) {
        fList = new JList ( new StackTraceListModel() );
        fList.setFont ( new Font ( "Dialog", Font.PLAIN, 12 ) );
        fList.setSelectionMode ( ListSelectionModel.SINGLE_SELECTION );
        fList.setVisibleRowCount ( 5 );
        fList.setCellRenderer ( new StackEntryRenderer() );
    }
    return fList;
}
