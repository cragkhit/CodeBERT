public void initNames() {
    localInitialize = true;
    DateFormatSymbols dateFormatSymbols = new DateFormatSymbols ( locale );
    String[] monthNames = dateFormatSymbols.getMonths();
    if ( comboBox.getItemCount() == 12 ) {
        comboBox.removeAllItems();
    }
    for ( int i = 0; i < 12; i++ ) {
        comboBox.addItem ( monthNames[i] );
    }
    localInitialize = false;
    comboBox.setSelectedIndex ( month );
}
