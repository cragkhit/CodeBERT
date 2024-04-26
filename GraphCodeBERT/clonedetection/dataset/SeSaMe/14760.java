public void setDay ( int d ) {
    if ( d < 1 ) {
        d = 1;
    }
    int maxDaysInMonth = getDaysInMonth();
    if ( d > maxDaysInMonth ) {
        d = maxDaysInMonth;
    }
    day = d;
    if ( selectedDay != null ) {
        selectedDay.setBackground ( oldDayBackgroundColor );
        selectedDay.repaint();
    }
    for ( int i = 7; i < 49; i++ ) {
        if ( days[i].getText().equals ( Integer.toString ( day ) ) ) {
            selectedDay = days[i];
            selectedDay.setBackground ( selectedColor );
            break;
        }
    }
    setFocus();
}
