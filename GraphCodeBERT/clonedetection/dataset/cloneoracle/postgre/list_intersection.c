List *
list_intersection(List *list1, List *list2)
{
	List	   *result;
	ListCell   *cell;

	if (list1 == NIL || list2 == NIL)
		return NIL;

	Assert(IsPointerList(list1));
	Assert(IsPointerList(list2));

	result = NIL;
	foreach(cell, list1)
	{
		if (list_member(list2, lfirst(cell)))
			result = lappend(result, lfirst(cell));
	}

	check_list_invariants(result);
	return result;
}
