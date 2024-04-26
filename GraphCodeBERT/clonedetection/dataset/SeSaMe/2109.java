@Override
public Object clone() {
    try {
        return cloneReset();
    } catch ( final CloneNotSupportedException ex ) {
        return null;
    }
}
