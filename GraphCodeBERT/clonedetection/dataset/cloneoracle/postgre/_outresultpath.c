static void
_outResultPath(StringInfo str, ResultPath *node)
{
	WRITE_NODE_TYPE("RESULTPATH");

	_outPathInfo(str, (Path *) node);

	WRITE_NODE_FIELD(quals);
}
