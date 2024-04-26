static PyObject *
audioop_bias(PyObject *self, PyObject *args)
{
        signed char *cp, *ncp;
        int len, size, val = 0;
        PyObject *rv;
        int i;
        int bias;

        if ( !PyArg_ParseTuple(args, "s#ii:bias",
                          &cp, &len, &size , &bias) )
                return 0;

        if ( size != 1 && size != 2 && size != 4) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
    
        rv = PyString_FromStringAndSize(NULL, len);
        if ( rv == 0 )
                return 0;
        ncp = (signed char *)PyString_AsString(rv);
    
    
        for ( i=0; i < len; i += size ) {
                if ( size == 1 )      val = (int)*CHARP(cp, i);
                else if ( size == 2 ) val = (int)*SHORTP(cp, i);
                else if ( size == 4 ) val = (int)*LONGP(cp, i);
        
                if ( size == 1 )      *CHARP(ncp, i) = (signed char)(val+bias);
                else if ( size == 2 ) *SHORTP(ncp, i) = (short)(val+bias);
                else if ( size == 4 ) *LONGP(ncp, i) = (Py_Int32)(val+bias);
        }
        return rv;
}
