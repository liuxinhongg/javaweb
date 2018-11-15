package com.bdxh.kmsale.utils.json.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.bdxh.kmsale.utils.json.factory.JsonBeanDeserializerFactory;
import com.bdxh.kmsale.utils.json.factory.JsonBeanSerializerFactory;

public class ValidationObjectMapper
        extends ObjectMapper
{
    private static final long serialVersionUID = -6964724122854961768L;

    public ValidationObjectMapper()
    {
        this._deserializationContext = new DefaultDeserializationContext.Impl(JsonBeanDeserializerFactory.instance);
        this._serializerFactory = new JsonBeanSerializerFactory(null);
    }
}
