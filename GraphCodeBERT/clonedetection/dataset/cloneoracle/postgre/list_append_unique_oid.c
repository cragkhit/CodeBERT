List *
list_append_unique_oid(List *list, Oid datum)
{
	if (list_member_oid(list, datum))
		return list;
	else
		return lappend_oid(list, datum);
}
