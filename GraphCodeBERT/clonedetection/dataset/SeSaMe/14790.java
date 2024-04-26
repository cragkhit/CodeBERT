public void setEnabled ( boolean enabled ) {
    super.setEnabled ( enabled );
    comboBox.setEnabled ( enabled );
    if ( spinner != null ) {
        spinner.setEnabled ( enabled );
    }
}
