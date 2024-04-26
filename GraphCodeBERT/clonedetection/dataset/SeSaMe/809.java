public void setCacheFile ( String fileName ) throws IOException {
    final Configuration configuration = getConfiguration();
    cacheFile = new PropertyCacheFile ( configuration, fileName );
    cacheFile.load();
}
