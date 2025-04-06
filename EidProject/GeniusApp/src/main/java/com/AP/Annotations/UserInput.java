package com.AP.Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UserInput {
    String label() default "";
    boolean required() default false;
}
