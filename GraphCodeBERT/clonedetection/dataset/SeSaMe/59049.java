public static Set<String> set ( String... ss ) {
    Set<String> set = new HashSet<>();
    set.addAll ( Arrays.asList ( ss ) );
    return set;
}
