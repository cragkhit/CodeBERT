public static boolean isOnType ( DetailAST blockComment ) {
    return isOnClass ( blockComment )
           || isOnInterface ( blockComment )
           || isOnEnum ( blockComment )
           || isOnAnnotationDef ( blockComment );
}
