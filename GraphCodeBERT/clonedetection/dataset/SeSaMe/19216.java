@CanIgnoreReturnValue
public Builder<K, V> orderKeysBy ( Comparator<? super K> keyComparator ) {
    this.keyComparator = checkNotNull ( keyComparator );
    return this;
}
