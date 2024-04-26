public void storeTime ( final double t ) {
    globalCurrentTime = t;
    softCurrentTime   = globalCurrentTime;
    h                 = globalCurrentTime - globalPreviousTime;
    setInterpolatedTime ( t );
    finalized  = false;
}
