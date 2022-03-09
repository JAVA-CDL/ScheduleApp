package com.luke.hot_list.annotation;

import java.lang.annotation.*;

/**
 * @author luke_long
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log{
    /**
     * 操作名称
     */
    String title() default "";
}