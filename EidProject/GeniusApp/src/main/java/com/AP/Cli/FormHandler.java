package com.AP.Cli;

import com.AP.Annotations.UserInput;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormHandler {
    public static void collectData(Object target){
        FormHandler.collectData(target,false);
    }
    public static void collectData(Object target, boolean isEditMode) {
        Class<?> clazz = target.getClass();

        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(UserInput.class)) {
                    field.setAccessible(true);

                    UserInput userInput = field.getAnnotation(UserInput.class);
                    String label = userInput.label();
                    String input = isEditMode ? getInputWithDefault(field, target, label) : InputHandler.getInput(label);

                    if (userInput.required() && input.isBlank()) {
                        System.out.println("This field is required, please enter a value.");
                        return;
                    }

                    setFieldValue(target, field, input);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }


    private static String getInputWithDefault(Field field, Object target, String label) {
        try {
            field.setAccessible(true);
            Object value = field.get(target);
            if (value != null) {
                var input = InputHandler.getInput(label + " (CurrentValue: "+value.toString()+")");

                if(input.isEmpty())
                return value.toString();
                else
                    return input;
            }
        } catch (IllegalAccessException e) {
            System.out.println("Error getting field value: " + e.getMessage());
        }
        return null;
    }

    private static void setFieldValue(Object target, Field field, String input) {
        try {
            field.setAccessible(true);


            if (field.getType() == String.class) {
                field.set(target, input);
            }

            else if (field.getType() == int.class) {
                field.set(target, Integer.parseInt(input));
            }

            else if (field.getType() == boolean.class) {
                field.set(target, Boolean.parseBoolean(input));
            }

            else if (field.getType() == double.class) {
                field.set(target, Double.parseDouble(input));
            }

            else if (field.getType() == LocalDateTime.class) {
                LocalDateTime date = LocalDateTime.parse(input);
                field.set(target, date);
            }
        } catch (Exception e) {
            System.out.println("Error setting field value: " + e.getMessage());
        }
    }
}
