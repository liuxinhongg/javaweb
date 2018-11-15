package com.bdxh.kmsale.utils.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer
        extends JsonSerializer<Date>
{
    private SimpleDateFormat dateFormat;

    public JsonDateSerializer(String format)
    {
        this.dateFormat = new SimpleDateFormat(format);
    }

    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException
    {
        String value = this.dateFormat.format(date);
        gen.writeString(value);
    }
}
