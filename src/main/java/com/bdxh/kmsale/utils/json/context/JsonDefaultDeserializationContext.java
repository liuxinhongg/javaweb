package com.bdxh.kmsale.utils.json.context;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;

public abstract class JsonDefaultDeserializationContext
        extends DefaultDeserializationContext
{
    private static final long serialVersionUID = 8591182696349988505L;

    public JsonDefaultDeserializationContext(DefaultDeserializationContext src, DeserializationConfig config, JsonParser jp, InjectableValues values)
    {
        super(src, config, jp, values);
    }

    public JsonDefaultDeserializationContext(DefaultDeserializationContext src, DeserializerFactory factory)
    {
        super(src, factory);
    }

    public JsonDefaultDeserializationContext(DeserializerFactory df, DeserializerCache cache)
    {
        super(df, cache);
    }
}
