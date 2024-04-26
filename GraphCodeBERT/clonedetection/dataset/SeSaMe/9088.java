public void setSequenceLabel ( @NonNull T label ) {
    this.label = label;
    if ( !labels.contains ( label ) ) {
        labels.add ( label );
    }
}
