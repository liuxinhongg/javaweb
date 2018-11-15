package com.bdxh.kmsale.utils.json.deserializer;

import com.bdxh.kmsale.utils.json.exception.JsonMapperException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import com.bdxh.kmsale.utils.json.annotation.NotNull;
import com.bdxh.kmsale.utils.json.utils.ReflectUtils;

public class JsonBeanDeserializer
        extends BeanDeserializer
{
    private static final long serialVersionUID = 3728090088905654162L;

    public JsonBeanDeserializer(BeanDeserializerBase src, boolean ignoreAllUnknown)
    {
        super(src, ignoreAllUnknown);
    }

    public JsonBeanDeserializer(BeanDeserializerBase src, HashSet<String> ignorableProps)
    {
        super(src, ignorableProps);
    }

    public JsonBeanDeserializer(BeanDeserializerBase src, NameTransformer unwrapper)
    {
        super(src, unwrapper);
    }

    public JsonBeanDeserializer(BeanDeserializerBase src, ObjectIdReader oir)
    {
        super(src, oir);
    }

    public JsonBeanDeserializer(BeanDeserializerBase src)
    {
        super(src);
    }

    public JsonBeanDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews)
    {
        super(builder, beanDesc, properties, backRefs, ignorableProps, ignoreAllUnknown, hasViews);
    }

    public Object deserialize(JsonParser jp, DeserializationContext ctxt)
            throws JsonProcessingException, IOException
    {
        Object result = super.deserialize(jp, ctxt);

        Field[] fields = result.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ((field.getAnnotation(NotNull.class) != null) && (ReflectUtils.getFieldValue(result, field) == null)) {
                throw new JsonMapperException(field.getName() + " is not null.");
            }
        }
        return result;
    }
}
