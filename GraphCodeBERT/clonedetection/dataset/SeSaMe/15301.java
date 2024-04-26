@GwtIncompatible 
public static List<Method> getForEachEntryDuplicateInitializingMethods() {
    return Arrays.asList (
               Helpers.getMethod ( MultisetForEachEntryTester.class, "testForEachEntryDuplicates" ) );
}
