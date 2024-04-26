@Override
public Object map ( Object input ) {
    List row = ( List ) input;
    String[] first = row.get ( 0 ).toString().split ( delimiter );
    String[] second = row.get ( 1 ).toString().split ( delimiter );
    String[] stdev = columns.length > 2 ? row.get ( 2 ).toString().split ( delimiter ) : null;
    double dist = 0;
    for ( int i = 0; i < first.length; i++ ) {
        double d = Double.parseDouble ( first[i] ) - Double.parseDouble ( second[i] );
        double s = stdev != null ? Double.parseDouble ( stdev[i] ) : 1;
        dist += ( d * d ) / ( s * s );
    }
    return Math.sqrt ( dist );
}
