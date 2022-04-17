package com.example.demo.util;


import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.List;

public class FieldCopyUtil {
    public static void merge(@NotNull Object from, @NotNull Object to) {
        assert from.getClass().getName().equals(to.getClass().getName());
        Field[] fields = from.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                if (fieldName.equals("id")){
                    continue;
                }
                Field fieldFrom = from.getClass().getDeclaredField(fieldName);
                fieldFrom.setAccessible(true);
                Object value = fieldFrom.get(from);
                Field toField = to.getClass().getDeclaredField(fieldName);
                toField.setAccessible(true);
                if (value != null && toField.get(to) != fieldFrom.get(from)){
                    toField.set(to,value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
    public static void merge(@NotNull Object from, @NotNull Object to, List<String> exceptFields){
        assert from.getClass().getName().equals(to.getClass().getName());
        Field[] fields = from.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                if (fieldName.equals("id")){
                    continue;
                }
                if (exceptFields.contains(fieldName)){
                    continue;
                }
                Field fieldFrom = from.getClass().getDeclaredField(fieldName);
                fieldFrom.setAccessible(true);
                Object value = fieldFrom.get(from);
                Field toField = to.getClass().getDeclaredField(fieldName);
                toField.setAccessible(true);
                if (value != null && toField.get(to) != fieldFrom.get(from)){
                    toField.set(to,value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
