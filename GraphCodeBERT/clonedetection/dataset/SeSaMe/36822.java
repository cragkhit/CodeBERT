static Tag[] firstSentenceTags ( DocImpl holder, String text ) {
    DocLocale doclocale = holder.env.doclocale;
    return getInlineTags ( holder,
                           doclocale.localeSpecificFirstSentence ( holder, text ) );
}
