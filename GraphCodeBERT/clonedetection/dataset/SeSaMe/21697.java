@Override
public Hashtable<String, Object> getDump() {
    Hashtable<String, Object> result = super.getDump();
    result.put ( TEXT_DPROP, ( ( Checkbox ) getSource() ).getLabel() );
    return result;
}
