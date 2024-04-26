public double calculateAUPRC() {
    if ( area != null ) {
        return area;
    }
    area = calculateArea();
    return area;
}
