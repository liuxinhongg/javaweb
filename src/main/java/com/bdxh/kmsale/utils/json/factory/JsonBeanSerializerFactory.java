package com.bdxh.kmsale.utils.json.factory;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.bdxh.kmsale.utils.json.context.JsonBeanSerializerBuilder;

public class JsonBeanSerializerFactory
        extends BeanSerializerFactory
{
    private static final long serialVersionUID = -348006947209039595L;

    public JsonBeanSerializerFactory(SerializerFactoryConfig config)
    {
        super(config);
    }

    protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription beanDesc)
    {
        return new JsonBeanSerializerBuilder(beanDesc);
    }
}
