static Aggref *
_readAggref(void)
{
	READ_LOCALS(Aggref);

	READ_OID_FIELD(aggfnoid);
	READ_OID_FIELD(aggtype);
	READ_NODE_FIELD(args);
	READ_UINT_FIELD(agglevelsup);
	READ_BOOL_FIELD(aggstar);
	READ_BOOL_FIELD(aggdistinct);
	READ_LOCATION_FIELD(location);

	READ_DONE();
}
