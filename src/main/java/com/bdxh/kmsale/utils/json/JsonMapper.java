package com.bdxh.kmsale.utils.json;

public class JsonMapper
{
    public static DefaultJsonMapper nonDefaultMapper()
    {
        return DefaultJsonMapper.nonDefaultMapper();
    }

    public static DefaultJsonMapper nonNullMapper()
    {
        return DefaultJsonMapper.nonNullMapper();
    }

    public static DefaultJsonMapper allMapper()
    {
        return DefaultJsonMapper.allMapper();
    }

    public static ValidationJsonMapper validationNonDefaultMapper()
    {
        return ValidationJsonMapper.nonDefaultMapper();
    }

    public static ValidationJsonMapper validationNonNullMapper()
    {
        return ValidationJsonMapper.nonNullMapper();
    }

    public static ValidationJsonMapper validationAllMapper()
    {
        return ValidationJsonMapper.allMapper();
    }
}
