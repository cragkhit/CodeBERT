boolean annotationApplicable ( JCAnnotation a, Symbol s ) {
    Attribute.Array arr = getAttributeTargetAttribute ( a.annotationType.type.tsym );
    Name[] targets;
    if ( arr == null ) {
        targets = defaultTargetMetaInfo ( a, s );
    } else {
        targets = new Name[arr.values.length];
        for ( int i = 0; i < arr.values.length; ++i ) {
            Attribute app = arr.values[i];
            if ( ! ( app instanceof Attribute.Enum ) ) {
                return true; 
            }
            Attribute.Enum e = ( Attribute.Enum ) app;
            targets[i] = e.value.name;
        }
    }
    for ( Name target : targets ) {
        if ( target == names.TYPE ) {
            if ( s.kind == TYP ) {
                return true;
            }
        } else if ( target == names.FIELD ) {
            if ( s.kind == VAR && s.owner.kind != MTH ) {
                return true;
            }
        } else if ( target == names.METHOD ) {
            if ( s.kind == MTH && !s.isConstructor() ) {
                return true;
            }
        } else if ( target == names.PARAMETER ) {
            if ( s.kind == VAR && s.owner.kind == MTH &&
                    ( s.flags() & PARAMETER ) != 0 ) {
                return true;
            }
        } else if ( target == names.CONSTRUCTOR ) {
            if ( s.kind == MTH && s.isConstructor() ) {
                return true;
            }
        } else if ( target == names.LOCAL_VARIABLE ) {
            if ( s.kind == VAR && s.owner.kind == MTH &&
                    ( s.flags() & PARAMETER ) == 0 ) {
                return true;
            }
        } else if ( target == names.ANNOTATION_TYPE ) {
            if ( s.kind == TYP && ( s.flags() & ANNOTATION ) != 0 ) {
                return true;
            }
        } else if ( target == names.PACKAGE ) {
            if ( s.kind == PCK ) {
                return true;
            }
        } else if ( target == names.TYPE_USE ) {
            if ( s.kind == VAR && s.owner.kind == MTH && s.type.hasTag ( NONE ) ) {
                return false;
            } else if ( s.kind == TYP || s.kind == VAR ||
                        ( s.kind == MTH && !s.isConstructor() &&
                          !s.type.getReturnType().hasTag ( VOID ) ) ||
                        ( s.kind == MTH && s.isConstructor() ) ) {
                return true;
            }
        } else if ( target == names.TYPE_PARAMETER ) {
            if ( s.kind == TYP && s.type.hasTag ( TYPEVAR ) ) {
                return true;
            }
        } else {
            return true;    
        }
    }
    return false;
}
