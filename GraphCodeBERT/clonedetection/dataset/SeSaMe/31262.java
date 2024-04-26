@Override
@SuppressWarnings ( "unchecked" )
public Enumeration<Permission> elements() {
    return ( Enumeration ) Collections.enumeration ( perms.values() );
}
