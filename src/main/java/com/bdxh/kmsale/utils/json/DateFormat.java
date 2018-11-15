package com.bdxh.kmsale.utils.json;

import java.text.SimpleDateFormat;

public abstract interface DateFormat
{
    public static final String STRING_SHORT_FORMAT = "yyyy-MM-dd";
    public static final String STRING_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat SIMPLE_SHORT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat SIMPLE_LONG_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
