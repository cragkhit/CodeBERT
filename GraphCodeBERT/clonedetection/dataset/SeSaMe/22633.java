public void scrollToComponentRectangle ( Component comp, int x, int y, int width, int height ) {
    scrollTo ( new ComponentRectChecker ( comp, x, y, width, height, Adjustable.HORIZONTAL ) );
    scrollTo ( new ComponentRectChecker ( comp, x, y, width, height, Adjustable.VERTICAL ) );
}
