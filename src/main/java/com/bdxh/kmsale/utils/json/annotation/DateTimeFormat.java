package com.bdxh.kmsale.utils.json.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface DateTimeFormat {
    String style() default "SS";

    ISO iso() default ISO.NONE;

    String pattern() default "yyyy-MM-dd HH:mm:ss";

    public static enum ISO {
        DATE, TIME, DATE_TIME, NONE;

        private ISO() {
        }
    }
}
