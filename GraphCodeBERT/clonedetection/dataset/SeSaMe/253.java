public void remove() {
    checkState ( key != Long.MIN_VALUE );
    prev.next = next;
    next.prev = prev;
    prev = next = null;
    type = null;
}
