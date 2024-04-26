static void
_outInhRelation(StringInfo str, InhRelation *node)
{
	WRITE_NODE_TYPE("INHRELATION");

	WRITE_NODE_FIELD(relation);
	WRITE_NODE_FIELD(options);
}
