@Override
public int compareTo ( UnsignedInteger other ) {
    checkNotNull ( other );
    return compare ( value, other.value );
}
