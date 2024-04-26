static void
_outBitmapAnd(StringInfo str, BitmapAnd *node)
{
	WRITE_NODE_TYPE("BITMAPAND");

	_outPlanInfo(str, (Plan *) node);

	WRITE_NODE_FIELD(bitmapplans);
}
