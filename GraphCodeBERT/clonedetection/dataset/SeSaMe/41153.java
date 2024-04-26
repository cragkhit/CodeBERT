protected Rectangle rectangleForCurrentValue() {
    int width = comboBox.getWidth();
    int height = comboBox.getHeight();
    Insets insets = getInsets();
    int buttonSize = height - ( insets.top + insets.bottom );
    if ( arrowButton != null ) {
        buttonSize = arrowButton.getWidth();
    }
    if ( BasicGraphicsUtils.isLeftToRight ( comboBox ) ) {
        return new Rectangle ( insets.left, insets.top,
                               width - ( insets.left + insets.right + buttonSize ),
                               height - ( insets.top + insets.bottom ) );
    } else {
        return new Rectangle ( insets.left + buttonSize, insets.top,
                               width - ( insets.left + insets.right + buttonSize ),
                               height - ( insets.top + insets.bottom ) );
    }
}
