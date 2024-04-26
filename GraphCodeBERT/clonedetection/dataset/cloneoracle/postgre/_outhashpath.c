static void
_outHashPath(StringInfo str, HashPath *node)
{
	WRITE_NODE_TYPE("HASHPATH");

	_outJoinPathInfo(str, (JoinPath *) node);

	WRITE_NODE_FIELD(path_hashclauses);
	WRITE_INT_FIELD(num_batches);
}
