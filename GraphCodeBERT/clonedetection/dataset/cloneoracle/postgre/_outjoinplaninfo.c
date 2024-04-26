static void
_outJoinPlanInfo(StringInfo str, Join *node)
{
	_outPlanInfo(str, (Plan *) node);

	WRITE_ENUM_FIELD(jointype, JoinType);
	WRITE_NODE_FIELD(joinqual);
}
