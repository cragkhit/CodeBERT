static PyObject *
audioop_alaw2lin(PyObject *self, PyObject *args)
{
        unsigned char *cp;
        unsigned char cval;
        signed char *ncp;
        int len, size, val;
        PyObject *rv;
        int i;

        if ( !PyArg_ParseTuple(args, "s#i:alaw2lin",
                               &cp, &len, &size) )
                return 0;

        if ( size != 1 && size != 2 && size != 4) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
    
        rv = PyString_FromStringAndSize(NULL, len*size);
        if ( rv == 0 )
                return 0;
        ncp = (signed char *)PyString_AsString(rv);
    
        for ( i=0; i < len*size; i += size ) {
                cval = *cp++;
                val = st_alaw2linear16(cval);
        
                if ( size == 1 )      *CHARP(ncp, i) = (signed char)(val >> 8);
                else if ( size == 2 ) *SHORTP(ncp, i) = (short)(val);
                else if ( size == 4 ) *LONGP(ncp, i) = (Py_Int32)(val<<16);
        }
        return rv;
}
