static PyObject *
audioop_lin2alaw(PyObject *self, PyObject *args)
{
        signed char *cp;
        unsigned char *ncp;
        int len, size, val = 0;
        PyObject *rv;
        int i;

        if ( !PyArg_ParseTuple(args, "s#i:lin2alaw",
                               &cp, &len, &size) )
                return 0;

        if ( size != 1 && size != 2 && size != 4) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
    
        rv = PyString_FromStringAndSize(NULL, len/size);
        if ( rv == 0 )
                return 0;
        ncp = (unsigned char *)PyString_AsString(rv);
    
        for ( i=0; i < len; i += size ) {
                if ( size == 1 )      val = ((int)*CHARP(cp, i)) << 8;
                else if ( size == 2 ) val = (int)*SHORTP(cp, i);
                else if ( size == 4 ) val = ((int)*LONGP(cp, i)) >> 16;

                *ncp++ = st_linear2alaw(val);
        }
        return rv;
}
