static void
_outRangeSubselect(StringInfo str, RangeSubselect *node)
{
	WRITE_NODE_TYPE("RANGESUBSELECT");

	WRITE_NODE_FIELD(subquery);
	WRITE_NODE_FIELD(alias);
}
