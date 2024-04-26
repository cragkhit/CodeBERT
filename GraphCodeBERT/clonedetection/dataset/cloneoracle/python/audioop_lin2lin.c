static PyObject *
audioop_lin2lin(PyObject *self, PyObject *args)
{
        signed char *cp;
        unsigned char *ncp;
        int len, size, size2, val = 0;
        PyObject *rv;
        int i, j;

        if ( !PyArg_ParseTuple(args, "s#ii:lin2lin",
                          &cp, &len, &size, &size2) )
                return 0;

        if ( (size != 1 && size != 2 && size != 4) ||
             (size2 != 1 && size2 != 2 && size2 != 4)) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
    
        rv = PyString_FromStringAndSize(NULL, (len/size)*size2);
        if ( rv == 0 )
                return 0;
        ncp = (unsigned char *)PyString_AsString(rv);
    
        for ( i=0, j=0; i < len; i += size, j += size2 ) {
                if ( size == 1 )      val = ((int)*CHARP(cp, i)) << 8;
                else if ( size == 2 ) val = (int)*SHORTP(cp, i);
                else if ( size == 4 ) val = ((int)*LONGP(cp, i)) >> 16;

                if ( size2 == 1 )  *CHARP(ncp, j) = (signed char)(val >> 8);
                else if ( size2 == 2 ) *SHORTP(ncp, j) = (short)(val);
                else if ( size2 == 4 ) *LONGP(ncp, j) = (Py_Int32)(val<<16);
        }
        return rv;
}
