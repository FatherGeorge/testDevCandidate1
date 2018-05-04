package org.parts.utils;

public interface Filter<T> {
    boolean shouldRemove(T t);
}
