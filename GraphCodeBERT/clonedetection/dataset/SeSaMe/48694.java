public final void clear() {
    int len = super.getLength();
    super.clear();
    if ( MAX <= len ) {
        m_indexFromQName.clear();
    }
}
