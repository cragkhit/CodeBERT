static void
_outAlias(StringInfo str, Alias *node)
{
	WRITE_NODE_TYPE("ALIAS");

	WRITE_STRING_FIELD(aliasname);
	WRITE_NODE_FIELD(colnames);
}
