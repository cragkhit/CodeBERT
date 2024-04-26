static WindowFunc *
_readWindowFunc(void)
{
	READ_LOCALS(WindowFunc);

	READ_OID_FIELD(winfnoid);
	READ_OID_FIELD(wintype);
	READ_NODE_FIELD(args);
	READ_UINT_FIELD(winref);
	READ_BOOL_FIELD(winstar);
	READ_BOOL_FIELD(winagg);
	READ_LOCATION_FIELD(location);

	READ_DONE();
}
