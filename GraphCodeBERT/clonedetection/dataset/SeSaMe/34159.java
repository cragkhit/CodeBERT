public static HttpRequestImpl newInstanceForAuthentication ( HttpRequestImpl other ) {
    return new HttpRequestImpl ( other.uri(), other.method(), other );
}
