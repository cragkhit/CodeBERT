public void setTag ( String tag ) {
    this.tag = tag;
    tagRegExp = CommonUtil.createPattern ( tag + "\\s*(.*$)" );
}
