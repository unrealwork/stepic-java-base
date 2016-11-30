package org.stepic.java.lambda;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.function.Function;
import java.util.function.Predicate;


public class TernaryOberator {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply(null));
        System.out.println(safeStringLength.apply("a"));
    }
}
