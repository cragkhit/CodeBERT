protected Set<String> getFlags ( ClassType type, List<Modifier> mods ) {
    Set<String> flags = mods.stream()
                        .map ( Modifier::getString )
                        .filter ( str -> !str.isEmpty() )
                        .map ( str -> "ACC_" + str.toUpperCase() )
                        .collect ( Collectors.toSet() );
    type.addSpecificFlags ( flags );
    return flags;
}
