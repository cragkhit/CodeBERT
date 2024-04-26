@Override
public MemoryWorkspace scopeOutOfWorkspaces() {
    MemoryWorkspace workspace = Nd4j.getMemoryManager().getCurrentWorkspace();
    if ( workspace == null ) {
        return new DummyWorkspace();
    } else {
        Nd4j.getMemoryManager().setCurrentWorkspace ( null );
        return workspace.tagOutOfScopeUse();
    }
}
