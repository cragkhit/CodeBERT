static ParameterizedType newParameterizedType ( Class<?> rawType, Type... arguments ) {
    return new ParameterizedTypeImpl (
               ClassOwnership.JVM_BEHAVIOR.getOwnerType ( rawType ), rawType, arguments );
}
