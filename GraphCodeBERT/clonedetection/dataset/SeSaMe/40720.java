public void updateChooser() {
    if ( !settingColor ) {
        lastLabel.setBackground ( getColorFromModel() );
        setColor ( getColorFromModel(), true, true, false );
    }
}
