static PyObject *
audioop_tomono(PyObject *self, PyObject *args)
{
        signed char *cp, *ncp;
        int len, size, val1 = 0, val2 = 0;
        double fac1, fac2, fval, maxval;
        PyObject *rv;
        int i;

        if ( !PyArg_ParseTuple(args, "s#idd:tomono",
	                       &cp, &len, &size, &fac1, &fac2 ) )
                return 0;
    
        if ( size == 1 ) maxval = (double) 0x7f;
        else if ( size == 2 ) maxval = (double) 0x7fff;
        else if ( size == 4 ) maxval = (double) 0x7fffffff;
        else {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
    
        rv = PyString_FromStringAndSize(NULL, len/2);
        if ( rv == 0 )
                return 0;
        ncp = (signed char *)PyString_AsString(rv);
    
    
        for ( i=0; i < len; i += size*2 ) {
                if ( size == 1 )      val1 = (int)*CHARP(cp, i);
                else if ( size == 2 ) val1 = (int)*SHORTP(cp, i);
                else if ( size == 4 ) val1 = (int)*LONGP(cp, i);
                if ( size == 1 )      val2 = (int)*CHARP(cp, i+1);
                else if ( size == 2 ) val2 = (int)*SHORTP(cp, i+2);
                else if ( size == 4 ) val2 = (int)*LONGP(cp, i+4);
                fval = (double)val1*fac1 + (double)val2*fac2;
                if ( fval > maxval ) fval = maxval;
                else if ( fval < -maxval ) fval = -maxval;
                val1 = (int)fval;
                if ( size == 1 )      *CHARP(ncp, i/2) = (signed char)val1;
                else if ( size == 2 ) *SHORTP(ncp, i/2) = (short)val1;
                else if ( size == 4 ) *LONGP(ncp, i/2)= (Py_Int32)val1;
        }
        return rv;
}
