static void
_outSubqueryScan(StringInfo str, SubqueryScan *node)
{
	WRITE_NODE_TYPE("SUBQUERYSCAN");

	_outScanInfo(str, (Scan *) node);

	WRITE_NODE_FIELD(subplan);
	WRITE_NODE_FIELD(subrtable);
}
