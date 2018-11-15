package com.bdxh.kmsale.utils.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.bdxh.kmsale.utils.json.exception.JsonMapperException;

import java.io.IOException;

public class JsonNotNullSerializer
        extends JsonSerializer<Object>
{
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException
    {
        if (value == null) {
            throw new JsonMapperException("");
        }
        gen.writeObject(value);
    }
}
