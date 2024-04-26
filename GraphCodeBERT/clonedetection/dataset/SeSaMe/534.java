@Override
public int compareTo ( Tag object ) {
    final int result;
    if ( line == object.line ) {
        result = Integer.compare ( column, object.column );
    } else {
        result = Integer.compare ( line, object.line );
    }
    return result;
}
