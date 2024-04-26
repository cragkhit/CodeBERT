public int getEntryOffset() {
    byteBuffer.position ( PERFDATA_PROLOG_ENTRYOFFSET_OFFSET );
    return byteBuffer.getInt();
}
