public void notifyValue ( XScrollbar obj, int type, int value, boolean isAdjusting ) {
    Scrollbar sb = ( Scrollbar ) target;
    sb.setValue ( value );
    postEvent ( new AdjustmentEvent ( sb, AdjustmentEvent.ADJUSTMENT_VALUE_CHANGED, type, value, isAdjusting ) );
}
