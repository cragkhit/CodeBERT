@Override
public void resetRowSelection() {
    if ( !updatingListSelectionModel ) {
        updatingListSelectionModel = true;
        try {
            super.resetRowSelection();
        } finally {
            updatingListSelectionModel = false;
        }
    }
}
