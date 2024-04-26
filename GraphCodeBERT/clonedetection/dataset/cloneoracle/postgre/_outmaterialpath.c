static void
_outMaterialPath(StringInfo str, MaterialPath *node)
{
	WRITE_NODE_TYPE("MATERIALPATH");

	_outPathInfo(str, (Path *) node);

	WRITE_NODE_FIELD(subpath);
}
