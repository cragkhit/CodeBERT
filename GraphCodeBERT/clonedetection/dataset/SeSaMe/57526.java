public void setRoles ( RoleList list ) {
    if ( list != null ) {
        roleList = new RoleList();
        for ( Iterator<?> roleIter = list.iterator();
                roleIter.hasNext(); ) {
            Role currRole = ( Role ) ( roleIter.next() );
            roleList.add ( ( Role ) ( currRole.clone() ) );
        }
    } else {
        roleList = null;
    }
    return;
}
