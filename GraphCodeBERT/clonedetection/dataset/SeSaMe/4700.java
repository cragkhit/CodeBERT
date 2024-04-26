public Circle getReverse() {
    return new Circle ( pole.negate(), x, y.negate(), tolerance );
}
