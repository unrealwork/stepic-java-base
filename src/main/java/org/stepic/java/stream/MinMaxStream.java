package org.stepic.java.stream;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shmagrinskiy on 11/30/16.
 */
public class MinMaxStream {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        final java.util.List<? extends T> list
                = stream.collect(Collectors.toCollection(java.util.ArrayList::new));
        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(java.util.Collections.min(list, order), java.util.Collections.max(list, order));
        }
    }
}
