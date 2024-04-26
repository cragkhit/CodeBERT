static PyObject *
audioop_minmax(PyObject *self, PyObject *args)
{
        signed char *cp;
        int len, size, val = 0;
        int i;
        int min = 0x7fffffff, max = -0x7fffffff;

        if (!PyArg_ParseTuple(args, "s#i:minmax", &cp, &len, &size))
                return NULL;
        if (size != 1 && size != 2 && size != 4) {
                PyErr_SetString(AudioopError, "Size should be 1, 2 or 4");
                return NULL;
        }
        for (i = 0; i < len; i += size) {
                if (size == 1) val = (int) *CHARP(cp, i);
                else if (size == 2) val = (int) *SHORTP(cp, i);
                else if (size == 4) val = (int) *LONGP(cp, i);
                if (val > max) max = val;
                if (val < min) min = val;
        }
        return Py_BuildValue("(ii)", min, max);
}
