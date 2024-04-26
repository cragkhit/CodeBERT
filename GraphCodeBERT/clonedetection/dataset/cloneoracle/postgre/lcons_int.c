List *
lcons_int(int datum, List *list)
{
	Assert(IsIntegerList(list));

	if (list == NIL)
		list = new_list(T_IntList);
	else
		new_head_cell(list);

	lfirst_int(list->head) = datum;
	check_list_invariants(list);
	return list;
}
