void
pq_sendstring(StringInfo buf, const char *str)
{
	int			slen = strlen(str);
	char	   *p;

	p = pg_server_to_client(str, slen);
	if (p != str)				/* actual conversion has been done? */
	{
		slen = strlen(p);
		appendBinaryStringInfo(buf, p, slen + 1);
		pfree(p);
	}
	else
		appendBinaryStringInfo(buf, str, slen + 1);
}
