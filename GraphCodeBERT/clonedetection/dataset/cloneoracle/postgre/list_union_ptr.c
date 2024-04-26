List *
list_union_ptr(List *list1, List *list2)
{
	List	   *result;
	ListCell   *cell;

	Assert(IsPointerList(list1));
	Assert(IsPointerList(list2));

	result = list_copy(list1);
	foreach(cell, list2)
	{
		if (!list_member_ptr(result, lfirst(cell)))
			result = lappend(result, lfirst(cell));
	}

	check_list_invariants(result);
	return result;
}
