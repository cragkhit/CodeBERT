public DocCommentTree getDocCommentTree0 ( Element element ) {
    DocCommentDuo duo = null;
    ElementKind kind = element.getKind();
    if ( kind == ElementKind.PACKAGE || kind == ElementKind.OTHER ) {
        duo = dcTreeCache.get ( element ); 
        if ( !isValidDuo ( duo ) && kind == ElementKind.PACKAGE ) {
            duo = getDocCommentTuple ( element );
        }
        if ( !isValidDuo ( duo ) ) {
            duo = configuration.cmtUtils.getHtmlCommentDuo ( element ); 
        }
    } else {
        duo = configuration.cmtUtils.getSyntheticCommentDuo ( element );
        if ( !isValidDuo ( duo ) ) {
            duo = dcTreeCache.get ( element ); 
        }
        if ( !isValidDuo ( duo ) ) {
            duo = getDocCommentTuple ( element ); 
        }
    }
    DocCommentTree docCommentTree = isValidDuo ( duo ) ? duo.dcTree : null;
    TreePath path = isValidDuo ( duo ) ? duo.treePath : null;
    if ( !dcTreeCache.containsKey ( element ) ) {
        if ( docCommentTree != null && path != null ) {
            if ( !configuration.isAllowScriptInComments() ) {
                try {
                    javaScriptScanner.scan ( docCommentTree, path, p -> {
                        throw new JavaScriptScanner.Fault();
                    } );
                } catch ( JavaScriptScanner.Fault jsf ) {
                    String text = configuration.getText ( "doclet.JavaScript_in_comment" );
                    throw new UncheckedDocletException ( new SimpleDocletException ( text, jsf ) );
                }
            }
            configuration.workArounds.runDocLint ( path );
        }
        dcTreeCache.put ( element, duo );
    }
    return docCommentTree;
}
