package com.bdxh.kmsale.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class DefaultJsonMapper
        extends AbstractJsonMapper
{
    private static final long serialVersionUID = 7859068366583121561L;
    private ObjectMapper mapper;

    public DefaultJsonMapper()
    {
        this(null);
    }

    public DefaultJsonMapper(JsonInclude.Include include)
    {
        this.mapper = new ObjectMapper();
        if (include != null) {
            this.mapper.setSerializationInclusion(include);
        }
        this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        this.mapper.setDateFormat(DateFormat.SIMPLE_LONG_FORMAT);
    }

    public static DefaultJsonMapper nonEmptyMapper()
    {
        return new DefaultJsonMapper(JsonInclude.Include.NON_EMPTY);
    }

    public static DefaultJsonMapper nonDefaultMapper()
    {
        return new DefaultJsonMapper(JsonInclude.Include.NON_DEFAULT);
    }

    public static DefaultJsonMapper nonNullMapper()
    {
        return new DefaultJsonMapper(JsonInclude.Include.NON_NULL);
    }

    public static DefaultJsonMapper allMapper()
    {
        return new DefaultJsonMapper();
    }

    public String toJson(Object object)
    {
        try
        {
            return this.mapper.writeValueAsString(object);
        }
        catch (IOException e)
        {
            System.out.println("write to json string error:" + object + ". " + e.getMessage());
        }
        return null;
    }

    public <T> T fromJson(String jsonString, Class<T> clazz)
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
            System.out.println("parse json string error:" + jsonString + ". " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public <T> T fromJson(String jsonString, JavaType javaType)
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
            System.out.println("parse json string error:" + jsonString + ". " + e.getMessage());
        }
        return null;
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
    {
        try
        {
            this.mapper.readerForUpdating(object).readValue(jsonString);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("update json string:" + jsonString + " to object:" + object + " error." + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("update json string:" + jsonString + " to object:" + object + " error." + e.getMessage());
        }
    }

    public String toJsonP(String functionName, Object object)
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

    public ObjectMapper getMapper()
    {
        return this.mapper;
    }
}
