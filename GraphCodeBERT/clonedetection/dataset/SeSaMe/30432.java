public void setDateFormatSymbols ( DateFormatSymbols newFormatSymbols ) {
    this.formatData = ( DateFormatSymbols ) newFormatSymbols.clone();
    useDateFormatSymbols = true;
}
