public double gMeasure ( int output ) {
    double precision = precision ( output );
    double recall = recall ( output );
    return EvaluationUtils.gMeasure ( precision, recall );
}
