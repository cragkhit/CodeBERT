static void
_outIndexScan(StringInfo str, IndexScan *node)
{
	WRITE_NODE_TYPE("INDEXSCAN");

	_outScanInfo(str, (Scan *) node);

	WRITE_OID_FIELD(indexid);
	WRITE_NODE_FIELD(indexqual);
	WRITE_NODE_FIELD(indexqualorig);
	WRITE_ENUM_FIELD(indexorderdir, ScanDirection);
}
