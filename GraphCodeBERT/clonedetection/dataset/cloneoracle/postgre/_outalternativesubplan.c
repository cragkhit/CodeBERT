static void
_outAlternativeSubPlan(StringInfo str, AlternativeSubPlan *node)
{
	WRITE_NODE_TYPE("ALTERNATIVESUBPLAN");

	WRITE_NODE_FIELD(subplans);
}
