public boolean checkNegative2() {
    TypeElement elementN2 = _elementUtils.getTypeElement ( "targets.negative.pa.Negative2" );
    if ( null == elementN2 || elementN2.getKind() != ElementKind.CLASS ) {
        reportError ( "Element Negative2 was not found or was not a class" );
        return false;
    }
    List<? extends Element> enclosedElements = elementN2.getEnclosedElements();
    for ( Element element : enclosedElements ) {
        String name = element.getSimpleName().toString();
        if ( "m1".equals ( name ) ) {
            AnnotationMirror am2 = findAnnotation ( element, "Anno2" );
            if ( _reportFailingCases && null == am2 ) {
                reportError ( "Couldn't find annotation Anno2 on method Negative2.m1" );
                return false;
            }
        } else if ( "m2".equals ( name ) ) {
            AnnotationMirror am1 = findAnnotation ( element, "Anno1" );
            if ( _reportFailingCases && null == am1 ) {
                reportError ( "Couldn't find annotation Anno1 on method Negative2.m2" );
                return false;
            }
            AnnotationMirror am3 = findAnnotation ( element, "FakeAnno3" );
            if ( _reportFailingCases && null == am3 ) {
                reportError ( "Couldn't find annotation FakeAnno3 on method Negative2.m2" );
                return false;
            }
        } else if ( "m3".equals ( name ) ) {
            AnnotationMirror am2 = findAnnotation ( element, "Anno2" );
            if ( _reportFailingCases && null == am2 ) {
                reportError ( "Couldn't find annotation Anno2 on method Negative2.m3" );
                return false;
            }
            AnnotationMirror am3 = findAnnotation ( element, "FakeAnno3" );
            if ( _reportFailingCases && null == am3 ) {
                reportError ( "Couldn't find annotation FakeAnno3 on method Negative2.m3" );
                return false;
            }
        } else if ( "m4".equals ( name ) ) {
            AnnotationMirror am4 = findAnnotation ( element, "Anno4" );
            if ( _reportFailingCases && null == am4 ) {
                reportError ( "Couldn't find annotation Anno4 on method Negative2.m4" );
                return false;
            }
            Map<? extends ExecutableElement, ? extends AnnotationValue> values = am4.getElementValues();
            for ( Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : values.entrySet() ) {
                if ( "value".equals ( entry.getKey().getSimpleName().toString() ) ) {
                    String value = entry.getValue().getValue().toString();
                    if ( !"123".equals ( value ) && !"<error>".equals ( value ) ) {
                        reportError ( "Unexpected value for Anno4 on Negative1.s1: " + value );
                        return false;
                    }
                }
            }
        }
    }
    return true;
}
