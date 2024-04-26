public Object[] toArray() {
    Object[] rv = new Object[delegate.size()];
    delegate.copyInto ( rv );
    return rv;
}
