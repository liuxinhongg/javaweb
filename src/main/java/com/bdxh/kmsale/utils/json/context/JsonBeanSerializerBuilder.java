package com.bdxh.kmsale.utils.json.context;

import com.bdxh.kmsale.utils.json.serializer.JsonBeanSerializer;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;


public class JsonBeanSerializerBuilder
        extends BeanSerializerBuilder
{
    public JsonBeanSerializerBuilder(BeanDescription beanDesc)
    {
        super(beanDesc);
    }

    public JsonBeanSerializerBuilder(BeanSerializerBuilder src)
    {
        super(src);
    }

    public JsonSerializer<?> build()
    {
        BeanPropertyWriter[] properties;
        if ((this._properties == null) || (this._properties.isEmpty()))
        {
            if ((this._anyGetter == null) && (this._objectIdWriter == null)) {
                return null;
            }
            properties = new BeanPropertyWriter[0];
        }
        else
        {
            properties = (BeanPropertyWriter[])this._properties.toArray(new BeanPropertyWriter[this._properties.size()]);
        }
        return new JsonBeanSerializer(this._beanDesc.getType(), this, properties, this._filteredProperties);
    }
}
