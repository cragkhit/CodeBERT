public void setPatternList ( List<Pattern> patternList ) {
    this.mPatternList = patternList;
    Vector<String> childNames = getPatternNames();
    mChildPattern.updateComboBoxEntries ( childNames, childNames );
}
