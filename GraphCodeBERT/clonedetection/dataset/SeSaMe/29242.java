public ChronoUnit toChronoUnit() {
    switch ( this ) {
    case NANOSECONDS:
        return ChronoUnit.NANOS;
    case MICROSECONDS:
        return ChronoUnit.MICROS;
    case MILLISECONDS:
        return ChronoUnit.MILLIS;
    case SECONDS:
        return ChronoUnit.SECONDS;
    case MINUTES:
        return ChronoUnit.MINUTES;
    case HOURS:
        return ChronoUnit.HOURS;
    case DAYS:
        return ChronoUnit.DAYS;
    default:
        throw new AssertionError();
    }
}
