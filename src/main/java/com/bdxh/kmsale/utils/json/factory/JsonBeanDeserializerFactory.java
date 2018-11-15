package com.bdxh.kmsale.utils.json.factory;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.bdxh.kmsale.utils.json.context.JsonBeanDeserializerBuilder;

public class JsonBeanDeserializerFactory
        extends BeanDeserializerFactory
{
    private static final long serialVersionUID = 2351431079715840821L;
    public static final JsonBeanDeserializerFactory instance = new JsonBeanDeserializerFactory(new DeserializerFactoryConfig());

    public JsonBeanDeserializerFactory(DeserializerFactoryConfig config)
    {
        super(config);
    }

    protected BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext ctxt, BeanDescription beanDesc)
    {
        return new JsonBeanDeserializerBuilder(beanDesc, ctxt.getConfig());
    }
}
