public DataBuffer.Type nd4jTypeFromOnnxType ( OnnxProto3.TensorProto.DataType dataType ) {
    switch ( dataType ) {
    case DOUBLE:
        return DataBuffer.Type.DOUBLE;
    case FLOAT:
        return DataBuffer.Type.FLOAT;
    case FLOAT16:
        return DataBuffer.Type.HALF;
    case INT32:
    case INT64:
        return DataBuffer.Type.INT;
    default:
        return DataBuffer.Type.UNKNOWN;
    }
}
