static void
_outBitmapOr(StringInfo str, BitmapOr *node)
{
	WRITE_NODE_TYPE("BITMAPOR");

	_outPlanInfo(str, (Plan *) node);

	WRITE_NODE_FIELD(bitmapplans);
}
