public void print() {
    for ( int i = 0; i < mCalendarMarkings.sizeCalendarMarkingList(); i++ ) {
        CalendarMarking marking = mCalendarMarkings.getCalendarMarking ( i );
        Calendar firstDay = Calendar.getInstance();
        firstDay.setTimeInMillis ( marking.getStartDate() );
        RepetitionHandler handler = sHandlerMap
                                    .get ( marking.getRepeatType() );
        firstDay = handler.getFirst ( firstDay, marking );
        printDate ( firstDay );
        while ( firstDay != null ) {
            firstDay = handler.getNext ( firstDay, marking );
            printDate ( firstDay );
        }
    }
}
