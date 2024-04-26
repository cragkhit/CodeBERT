void scanStats ( List<? extends JCStatement> trees ) {
    if ( trees != null )
        for ( List<? extends JCStatement> l = trees; l.nonEmpty(); l = l.tail ) {
            scanStat ( l.head );
        }
}
