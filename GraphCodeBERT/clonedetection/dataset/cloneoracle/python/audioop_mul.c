static PyObject *
audioop_mul(PyObject *self, PyObject *args)
{
        signed char *cp, *ncp;
        int len, size, val = 0;
        double factor, fval, maxval;
        PyObject *rv;
        int i;

        if ( !PyArg_ParseTuple(args, "s#id:mul", &cp, &len, &size, &factor ) )
                return 0;
    
        if ( size == 1 ) maxval = (double) 0x7f;
        else if ( size == 2 ) maxval = (double) 0x7fff;
        else if ( size == 4 ) maxval = (double) 0x7fffffff;
        else {
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
                fval = (double)val*factor;
                if ( fval > maxval ) fval = maxval;
                else if ( fval < -maxval ) fval = -maxval;
                val = (int)fval;
                if ( size == 1 )      *CHARP(ncp, i) = (signed char)val;
                else if ( size == 2 ) *SHORTP(ncp, i) = (short)val;
                else if ( size == 4 ) *LONGP(ncp, i) = (Py_Int32)val;
        }
        return rv;
}
