package com.bdxh.kmsale.utils.json;

import java.io.Serializable;

public abstract class AbstractJsonMapper
        implements Serializable
{
    private static final long serialVersionUID = -4331963939509111225L;

    protected static boolean isEmpty(CharSequence cs)
    {
        return (cs == null) || (cs.length() == 0);
    }
}
