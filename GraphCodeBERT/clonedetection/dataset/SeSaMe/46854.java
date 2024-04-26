protected int mapDragOperationFromModifiers ( MouseEvent e ) {
    int mods = e.getModifiersEx();
    int btns = mods & ButtonMask;
    if ( ! ( btns == InputEvent.BUTTON1_DOWN_MASK ||
             btns == InputEvent.BUTTON2_DOWN_MASK ) ) {
        return DnDConstants.ACTION_NONE;
    }
    return
        SunDragSourceContextPeer.convertModifiersToDropAction ( mods,
                getSourceActions() );
}
