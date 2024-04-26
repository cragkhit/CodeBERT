static void
_outTidPath(StringInfo str, TidPath *node)
{
	WRITE_NODE_TYPE("TIDPATH");

	_outPathInfo(str, (Path *) node);

	WRITE_NODE_FIELD(tidquals);
}
