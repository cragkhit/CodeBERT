public MemoryAccessLog getReportFor ( long address, int size ) {
    List<Tag> tags = new ArrayList<>();
    tags.addAll ( this.operationStack );
    List<MemoryOperation> operations = new ArrayList<>();
    if ( this.buffer0 != null ) {
        int pointerToStart = ( this.insertionPosition + this.buffer0.length - this.currentEntries ) % this.buffer0.length;
        int currentPosition = ( this.insertionPosition + this.buffer0.length - 1 ) % this.buffer0.length;
        long currentWrite = this.timer;
        do {
            long nextAddress = this.buffer0[currentPosition];
            int nextArgument = this.buffer1[currentPosition];
            byte nextOp = this.operation[currentPosition];
            switch ( nextOp ) {
            case POP_OPERATION: {
                tags.add ( getTagForId ( nextArgument ) );
                break;
            }
            case PUSH_OPERATION: {
                tags.remove ( tags.size() - 1 );
                break;
            }
            default: {
                boolean isMatch = false;
                if ( address < nextAddress ) {
                    long diff = nextAddress - address;
                    if ( diff < size ) {
                        isMatch = true;
                    }
                } else {
                    long diff = address - nextAddress;
                    if ( diff < nextArgument ) {
                        isMatch = true;
                    }
                }
                if ( isMatch ) {
                    List<Tag> stack = new ArrayList<>();
                    stack.addAll ( tags );
                    MemoryOperation nextOperation = new MemoryOperation ( nextOp, currentWrite, nextAddress,
                        nextArgument, stack );
                    operations.add ( nextOperation );
                }
                currentWrite--;
            }
            }
            currentPosition = ( currentPosition + this.buffer0.length - 1 ) % this.buffer0.length;
        } while ( currentPosition != pointerToStart );
    }
    return new MemoryAccessLog ( operations );
}
