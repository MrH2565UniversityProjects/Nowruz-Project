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

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(UserInput.class)) {
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
    }

    private static String getInputWithDefault(Field field, Object target, String label) {
        try {
            field.setAccessible(true);
            Object value = field.get(target);
            if (value != null) {
                return value.toString();
            }
        } catch (IllegalAccessException e) {
            System.out.println("Error getting field value: " + e.getMessage());
        }
        return InputHandler.getInput(label);
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime date = LocalDateTime.parse(input, formatter);
                field.set(target, date);
            }
        } catch (Exception e) {
            System.out.println("Error setting field value: " + e.getMessage());
        }
    }
}
