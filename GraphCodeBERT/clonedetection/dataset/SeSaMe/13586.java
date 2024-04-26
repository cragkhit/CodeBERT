Map<ImportEntry, Collection<ImportComment>> reassignComments ( Collection<ImportEntry> resultantImports ) {
    Map<ImportEntry, Collection<OriginalImportEntry>> importAssignments = assignRemovedImports ( resultantImports );
    Map<ImportEntry, Collection<ImportComment>> commentAssignments =
        new HashMap<ImportEntry, Collection<ImportComment>>();
    for ( Map.Entry<ImportEntry, Collection<OriginalImportEntry>> importAssignment : importAssignments.entrySet() ) {
        ImportEntry targetImport = importAssignment.getKey();
        if ( targetImport != null ) {
            Deque<ImportComment> assignedComments = new ArrayDeque<ImportComment>();
            Collection<OriginalImportEntry> assignedImports = importAssignment.getValue();
            Iterator<OriginalImportEntry> nextAssignedImportIterator = assignedImports.iterator();
            if ( nextAssignedImportIterator.hasNext() ) {
                nextAssignedImportIterator.next();
            }
            Iterator<OriginalImportEntry> assignedImportIterator = assignedImports.iterator();
            while ( assignedImportIterator.hasNext() ) {
                OriginalImportEntry currentAssignedImport = assignedImportIterator.next();
                OriginalImportEntry nextAssignedImport =
                    nextAssignedImportIterator.hasNext() ? nextAssignedImportIterator.next() : null;
                assignedComments.addAll ( currentAssignedImport.comments );
                if ( nextAssignedImport != null && hasFloatingComment ( nextAssignedImport ) ) {
                    ImportComment lastComment = assignedComments.removeLast();
                    ImportComment lastCommentWithTrailingBlankLine = new ImportComment ( lastComment.region, 2 );
                    assignedComments.add ( lastCommentWithTrailingBlankLine );
                }
            }
            commentAssignments.put ( targetImport, assignedComments );
        }
    }
    return commentAssignments;
}
