List *
lappend_int(List *list, int datum)
{
	Assert(IsIntegerList(list));

	if (list == NIL)
		list = new_list(T_IntList);
	else
		new_tail_cell(list);

	lfirst_int(list->tail) = datum;
	check_list_invariants(list);
	return list;
}
