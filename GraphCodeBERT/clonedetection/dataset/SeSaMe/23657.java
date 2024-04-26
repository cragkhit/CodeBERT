@Test ( dataProvider = "NavigableSet<?>", dataProviderClass = EmptyNavigableSet.class )
public void testComparatorIsNull ( String description, NavigableSet<?> navigableSet ) {
    Comparator comparator = navigableSet.comparator();
    assertTrue ( comparator == null || comparator == Collections.reverseOrder(), description + ": Comparator (" + comparator + ") is not null." );
}
