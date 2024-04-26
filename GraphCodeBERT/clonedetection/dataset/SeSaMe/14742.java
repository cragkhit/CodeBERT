public void setDate ( Date date ) {
    Date oldDate = calendar.getTime();
    calendar.setTime ( date );
    int year = calendar.get ( Calendar.YEAR );
    int month = calendar.get ( Calendar.MONTH );
    int day = calendar.get ( Calendar.DAY_OF_MONTH );
    yearChooser.setYear ( year );
    monthChooser.setMonth ( month );
    dayChooser.setCalendar ( calendar );
    dayChooser.setDay ( day );
    firePropertyChange ( DATE_PROPERTY, oldDate, date );
}
