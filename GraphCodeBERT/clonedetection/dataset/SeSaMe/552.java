@Override
public Component getTableCellRendererComponent ( JTable table,
        Object value,
        boolean isSelected,
        boolean hasFocus,
        int row, int column ) {
    if ( isSelected ) {
        setBackground ( table.getSelectionBackground() );
    } else {
        setBackground ( table.getBackground() );
    }
    visibleRow = row;
    return this;
}
