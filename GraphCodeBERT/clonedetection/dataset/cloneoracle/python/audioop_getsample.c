static PyObject *
audioop_getsample(PyObject *self, PyObject *args)
{
        signed char *cp;
        int len, size, val = 0;
        int i;

        if ( !PyArg_ParseTuple(args, "s#ii:getsample", &cp, &len, &size, &i) )
                return 0;
        if ( size != 1 && size != 2 && size != 4 ) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return 0;
        }
        if ( i < 0 || i >= len/size ) {
                PyErr_SetString(AudioopError, "Index out of range");
                return 0;
        }
        if ( size == 1 )      val = (int)*CHARP(cp, i);
        else if ( size == 2 ) val = (int)*SHORTP(cp, i*2);
        else if ( size == 4 ) val = (int)*LONGP(cp, i*4);
        return PyInt_FromLong(val);
}
