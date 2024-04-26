@Override
public String getMarkerType() {
    return this.id == IProblem.Task
           ? MARKER_TYPE_TASK
           : MARKER_TYPE_PROBLEM;
}
