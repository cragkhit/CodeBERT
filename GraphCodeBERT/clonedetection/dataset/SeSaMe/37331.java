void process ( CompiledMethodInfo methodInfo, DataPatch dataPatch ) {
    Reference reference = dataPatch.reference;
    if ( reference instanceof ConstantReference ) {
        processConstantReference ( dataPatch, methodInfo );
    } else if ( reference instanceof DataSectionReference ) {
        processDataSectionReference ( dataPatch, methodInfo );
    } else {
        throw new InternalError ( "Unknown data patch reference: " + reference );
    }
}
