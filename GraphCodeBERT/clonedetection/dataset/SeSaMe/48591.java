public final void removeLastElem() {
    if ( m_firstFree > 0 ) {
        m_map[m_firstFree] = null;
        m_firstFree--;
    }
}
