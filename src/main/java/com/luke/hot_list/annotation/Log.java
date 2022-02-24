package com.luke.hot_list.annotation;

import java.lang.annotation.*;

/**
 * @author luke_long
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log{
    /**
     * 操作名称
     */
    String title() default "";
}