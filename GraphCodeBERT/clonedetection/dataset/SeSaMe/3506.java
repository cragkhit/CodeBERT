public static <T extends RealFieldElement<T>> T max ( final T e1, final T e2 ) {
    return e1.subtract ( e2 ).getReal() >= 0 ? e1 : e2;
}
