@CanIgnoreReturnValue
public <C extends Closeable> C register ( @Nullable C closeable ) {
    if ( closeable != null ) {
        stack.addFirst ( closeable );
    }
    return closeable;
}
