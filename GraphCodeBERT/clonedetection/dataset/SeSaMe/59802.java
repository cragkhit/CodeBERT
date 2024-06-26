boolean bind ( Environment env, Context ctx ) {
    try {
        field = ctx.getField ( env, id );
        if ( field == null ) {
            for ( ClassDefinition cdef = ctx.field.getClassDefinition();
                    cdef != null; cdef = cdef.getOuterClass() ) {
                if ( cdef.findAnyMethod ( env, id ) != null ) {
                    env.error ( where, "invalid.var", id,
                                ctx.field.getClassDeclaration() );
                    return false;
                }
            }
            env.error ( where, "undef.var", id );
            return false;
        }
        type = field.getType();
        if ( !ctx.field.getClassDefinition().canAccess ( env, field ) ) {
            env.error ( where, "no.field.access",
                        id, field.getClassDeclaration(),
                        ctx.field.getClassDeclaration() );
            return false;
        }
        if ( field.isLocal() ) {
            LocalMember local = ( LocalMember ) field;
            if ( local.scopeNumber < ctx.frameNumber ) {
                implementation = ctx.makeReference ( env, local );
            }
        } else {
            MemberDefinition f = field;
            if ( f.reportDeprecated ( env ) ) {
                env.error ( where, "warn.field.is.deprecated",
                            id, f.getClassDefinition() );
            }
            ClassDefinition fclass = f.getClassDefinition();
            if ( fclass != ctx.field.getClassDefinition() ) {
                MemberDefinition f2 = ctx.getApparentField ( env, id );
                if ( f2 != null && f2 != f ) {
                    ClassDefinition c = ctx.findScope ( env, fclass );
                    if ( c == null ) {
                        c = f.getClassDefinition();
                    }
                    if ( f2.isLocal() ) {
                        env.error ( where, "inherited.hides.local",
                                    id, c.getClassDeclaration() );
                    } else {
                        env.error ( where, "inherited.hides.field",
                                    id, c.getClassDeclaration(),
                                    f2.getClassDeclaration() );
                    }
                }
            }
            if ( f.isStatic() ) {
                Expression base = new TypeExpression ( where,
                                                       f.getClassDeclaration().getType() );
                implementation = new FieldExpression ( where, null, f );
            } else {
                Expression base = ctx.findOuterLink ( env, where, f );
                if ( base != null ) {
                    implementation = new FieldExpression ( where, base, f );
                }
            }
        }
        if ( !ctx.canReach ( env, field ) ) {
            env.error ( where, "forward.ref",
                        id, field.getClassDeclaration() );
            return false;
        }
        return true;
    } catch ( ClassNotFound e ) {
        env.error ( where, "class.not.found", e.name, ctx.field );
    } catch ( AmbiguousMember e ) {
        env.error ( where, "ambig.field", id,
                    e.field1.getClassDeclaration(),
                    e.field2.getClassDeclaration() );
    }
    return false;
}
