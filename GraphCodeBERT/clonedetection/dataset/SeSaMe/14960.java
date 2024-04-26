public static String removeHtmlTagsFromString ( String text ) {
    if ( HtmlTools.isHtmlNode ( text ) ) {
        return removeAllTagsFromString ( text ); 
    } else {
        return text;
    }
}
