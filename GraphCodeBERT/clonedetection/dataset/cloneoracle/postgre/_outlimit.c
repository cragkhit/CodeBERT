static void
_outLimit(StringInfo str, Limit *node)
{
	WRITE_NODE_TYPE("LIMIT");

	_outPlanInfo(str, (Plan *) node);

	WRITE_NODE_FIELD(limitOffset);
	WRITE_NODE_FIELD(limitCount);
}
