protected int getWidthOfHighValueLabel() {
    Component label = getHighestValueLabel();
    int width = 0;
    if ( label != null ) {
        width = label.getPreferredSize().width;
    }
    return width;
}
