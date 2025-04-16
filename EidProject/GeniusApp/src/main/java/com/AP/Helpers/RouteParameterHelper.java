package com.AP.Helpers;

public class RouteParameterHelper {
    public static <T> T getParameter(Object[] params, int index, Class<T> type, T defaultValue) {
        if (params == null || index >= params.length || params[index] == null)
            return defaultValue;

        Object value = params[index];
        if (type.isInstance(value))
            return type.cast(value);

        return defaultValue;
    }
}
