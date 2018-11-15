package com.bdxh.kmsale.utils.json.exception;

import com.fasterxml.jackson.core.JsonGenerationException;

public class JsonMapperException
        extends JsonGenerationException
{
    private static final long serialVersionUID = 5868593171195099592L;

    public JsonMapperException(String msg, Throwable rootCause)
    {
        super(msg, rootCause);
    }

    public JsonMapperException(String msg)
    {
        super(msg);
    }

    public JsonMapperException(Throwable rootCause)
    {
        super(rootCause);
    }
}
