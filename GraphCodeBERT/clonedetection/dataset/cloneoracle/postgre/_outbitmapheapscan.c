static void
_outBitmapHeapScan(StringInfo str, BitmapHeapScan *node)
{
	WRITE_NODE_TYPE("BITMAPHEAPSCAN");

	_outScanInfo(str, (Scan *) node);

	WRITE_NODE_FIELD(bitmapqualorig);
}
