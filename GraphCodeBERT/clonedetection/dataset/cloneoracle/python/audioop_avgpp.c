static PyObject *
audioop_avgpp(PyObject *self, PyObject *args)
{
        signed char *cp;
        int len, size, val = 0, prevval = 0, prevextremevalid = 0,
                prevextreme = 0;
        int i;
        double avg = 0.0;
        int diff, prevdiff, extremediff, nextreme = 0;

        if ( !PyArg_ParseTuple(args, "s#i:avgpp", &cp, &len, &size) )
                return 0;
        if ( size != 1 && size != 2 && size != 4 ) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
        /* Compute first delta value ahead. Also automatically makes us
        ** skip the first extreme value
        */
        if ( size == 1 )      prevval = (int)*CHARP(cp, 0);
        else if ( size == 2 ) prevval = (int)*SHORTP(cp, 0);
        else if ( size == 4 ) prevval = (int)*LONGP(cp, 0);
        if ( size == 1 )      val = (int)*CHARP(cp, size);
        else if ( size == 2 ) val = (int)*SHORTP(cp, size);
        else if ( size == 4 ) val = (int)*LONGP(cp, size);
        prevdiff = val - prevval;
    
        for ( i=size; i<len; i+= size) {
                if ( size == 1 )      val = (int)*CHARP(cp, i);
                else if ( size == 2 ) val = (int)*SHORTP(cp, i);
                else if ( size == 4 ) val = (int)*LONGP(cp, i);
                diff = val - prevval;
                if ( diff*prevdiff < 0 ) {
                        /* Derivative changed sign. Compute difference to last
                        ** extreme value and remember.
                        */
                        if ( prevextremevalid ) {
                                extremediff = prevval - prevextreme;
                                if ( extremediff < 0 )
                                        extremediff = -extremediff;
                                avg += extremediff;
                                nextreme++;
                        }
                        prevextremevalid = 1;
                        prevextreme = prevval;
                }
                prevval = val;
                if ( diff != 0 )
                        prevdiff = diff;        
        }
        if ( nextreme == 0 )
                val = 0;
        else
                val = (int)(avg / (double)nextreme);
        return PyInt_FromLong(val);
}
