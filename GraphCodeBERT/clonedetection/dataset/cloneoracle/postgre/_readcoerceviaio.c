static CoerceViaIO *
_readCoerceViaIO(void)
{
	READ_LOCALS(CoerceViaIO);

	READ_NODE_FIELD(arg);
	READ_OID_FIELD(resulttype);
	READ_ENUM_FIELD(coerceformat, CoercionForm);
	READ_LOCATION_FIELD(location);

	READ_DONE();
}
