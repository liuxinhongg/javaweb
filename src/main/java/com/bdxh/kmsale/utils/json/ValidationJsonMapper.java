package com.bdxh.kmsale.utils.json;

import com.bdxh.kmsale.utils.json.context.ValidationObjectMapper;
import com.bdxh.kmsale.utils.json.exception.JsonMapperException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class ValidationJsonMapper
        extends AbstractJsonMapper
{
    private static final long serialVersionUID = -8057661318078795700L;
    private ValidationObjectMapper mapper;

    public ValidationJsonMapper()
    {
        this(null);
    }

    private ValidationJsonMapper(JsonInclude.Include include)
    {
        this.mapper = new ValidationObjectMapper();
        if (include != null) {
            this.mapper.setSerializationInclusion(include);
        }
        this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        this.mapper.setDateFormat(DateFormat.SIMPLE_LONG_FORMAT);
    }

    public static ValidationJsonMapper nonDefaultMapper()
    {
        return new ValidationJsonMapper(JsonInclude.Include.NON_DEFAULT);
    }

    public static ValidationJsonMapper nonNullMapper()
    {
        return new ValidationJsonMapper(JsonInclude.Include.NON_NULL);
    }

    public static ValidationJsonMapper allMapper()
    {
        return new ValidationJsonMapper(null);
    }

    public String toJson(Object object)
            throws JsonMapperException
    {
        try
        {
            return this.mapper.writeValueAsString(object);
        }
        catch (IOException e)
        {
            throw new JsonMapperException("write to json string error:" + object + ", " + e.getMessage());
        }
    }

    public <T> T fromJson(String jsonString, Class<T> clazz)
            throws JsonMapperException
    {
        if (isEmpty(jsonString)) {
            return null;
        }
        try
        {
            return (T)this.mapper.readValue(jsonString, clazz);
        }
        catch (IOException e)
        {
            throw new JsonMapperException("parse json string error:" + jsonString + ", " + e.getMessage());
        }
    }

    public <T> T fromJson(String jsonString, JavaType javaType)
            throws JsonMapperException
    {
        if (isEmpty(jsonString)) {
            return null;
        }
        try
        {
            return (T)this.mapper.readValue(jsonString, javaType);
        }
        catch (IOException e)
        {
            throw new JsonMapperException("parse json string error:" + jsonString + ". " + e.getMessage());
        }
    }

    public JavaType contructCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass)
    {
        return this.mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    public JavaType contructMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass)
    {
        return this.mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }

    public void update(String jsonString, Object object)
            throws JsonMapperException
    {
        try
        {
            this.mapper.readerForUpdating(object).readValue(jsonString);
        }
        catch (IOException e)
        {
            throw new JsonMapperException("update json string:" + jsonString + " to object:" + object + " error. " + e.getMessage());
        }
    }

    public String toJsonP(String functionName, Object object)
            throws JsonMapperException
    {
        return toJson(new JSONPObject(functionName, object));
    }

    public void enableEnumUseToString()
    {
        this.mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        this.mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    }

    public void enableJaxbAnnotation()
    {
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        this.mapper.registerModule(module);
    }
}
