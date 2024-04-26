static PyObject *
audioop_avg(PyObject *self, PyObject *args)
{
        signed char *cp;
        int len, size, val = 0;
        int i;
        double avg = 0.0;

        if ( !PyArg_ParseTuple(args, "s#i:avg", &cp, &len, &size) )
                return 0;
        if ( size != 1 && size != 2 && size != 4 ) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
        for ( i=0; i<len; i+= size) {
                if ( size == 1 )      val = (int)*CHARP(cp, i);
                else if ( size == 2 ) val = (int)*SHORTP(cp, i);
                else if ( size == 4 ) val = (int)*LONGP(cp, i);
                avg += val;
        }
        if ( len == 0 )
                val = 0;
        else
                val = (int)(avg / (double)(len/size));
        return PyInt_FromLong(val);
}
