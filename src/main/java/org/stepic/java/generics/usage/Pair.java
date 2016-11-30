package org.stepic.java.generics.usage;

import java.util.NoSuchElementException;

class Pair<T, S> {
    private T first;
    private S second;


    public static <T, S> Pair<T, S> of(T first, S second) {
        return new Pair<T, S>(first, second);
    }

    private Pair(T first, S second) {
        this.first = first;
    }

    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException("No first value present");
        }
        return first;
    }

    public S getSecond() {
        if (second == null) {
            throw new NoSuchElementException("No first value present");
        }
        return second;
    }
}
