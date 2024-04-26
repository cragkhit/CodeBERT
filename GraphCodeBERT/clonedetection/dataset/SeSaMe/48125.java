public Component getTableCellRendererComponent ( JTable table,
        Object value,
        boolean isSelected,
        boolean hasFocus,
        int row, int column ) {
    Color background;
    Color foreground;
    if ( isSelected ) {
        background = table.getSelectionBackground();
        foreground = table.getSelectionForeground();
    } else {
        background = table.getBackground();
        foreground = table.getForeground();
    }
    highlightBorder = null;
    if ( realEditingRow() == row && getEditingColumn() == column ) {
        background = UIManager.getColor ( "Table.focusCellBackground" );
        foreground = UIManager.getColor ( "Table.focusCellForeground" );
    } else if ( hasFocus ) {
        highlightBorder = UIManager.getBorder
                          ( "Table.focusCellHighlightBorder" );
        if ( isCellEditable ( row, column ) ) {
            background = UIManager.getColor
                         ( "Table.focusCellBackground" );
            foreground = UIManager.getColor
                         ( "Table.focusCellForeground" );
        }
    }
    visibleRow = row;
    setBackground ( background );
    TreeCellRenderer tcr = getCellRenderer();
    if ( tcr instanceof DefaultTreeCellRenderer ) {
        DefaultTreeCellRenderer dtcr = ( ( DefaultTreeCellRenderer ) tcr );
        if ( isSelected ) {
            dtcr.setTextSelectionColor ( foreground );
            dtcr.setBackgroundSelectionColor ( background );
        } else {
            dtcr.setTextNonSelectionColor ( foreground );
            dtcr.setBackgroundNonSelectionColor ( background );
        }
    }
    return this;
}
