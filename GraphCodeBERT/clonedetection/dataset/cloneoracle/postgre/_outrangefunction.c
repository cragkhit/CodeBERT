static void
_outRangeFunction(StringInfo str, RangeFunction *node)
{
	WRITE_NODE_TYPE("RANGEFUNCTION");

	WRITE_NODE_FIELD(funccallnode);
	WRITE_NODE_FIELD(alias);
	WRITE_NODE_FIELD(coldeflist);
}
