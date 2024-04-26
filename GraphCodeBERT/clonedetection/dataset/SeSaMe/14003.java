protected void readBinaryChildren ( ClassFile classFile, HashMap newElements, IBinaryType typeInfo ) {
    ArrayList childrenHandles = new ArrayList();
    BinaryType type = ( BinaryType ) classFile.getType();
    ArrayList typeParameterHandles = new ArrayList();
    if ( typeInfo != null ) { 
        generateAnnotationsInfos ( type, typeInfo.getAnnotations(), typeInfo.getTagBits(), newElements );
        generateTypeParameterInfos ( type, typeInfo.getGenericSignature(), newElements, typeParameterHandles );
        generateFieldInfos ( type, typeInfo, newElements, childrenHandles );
        generateMethodInfos ( type, typeInfo, newElements, childrenHandles, typeParameterHandles );
        generateInnerClassHandles ( type, typeInfo, childrenHandles ); 
    }
    this.binaryChildren = new JavaElement[childrenHandles.size()];
    childrenHandles.toArray ( this.binaryChildren );
    int typeParameterHandleSize = typeParameterHandles.size();
    if ( typeParameterHandleSize == 0 ) {
        this.typeParameters = TypeParameter.NO_TYPE_PARAMETERS;
    } else {
        this.typeParameters = new ITypeParameter[typeParameterHandleSize];
        typeParameterHandles.toArray ( this.typeParameters );
    }
}
