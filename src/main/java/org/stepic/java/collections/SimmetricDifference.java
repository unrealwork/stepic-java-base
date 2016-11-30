package org.stepic.java.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class SimmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> d = new HashSet<T>();
        for (T o : set1) {
            if (set2.contains(o)) {
                d.add(o);
            }
        }
        Set<T> symD = new HashSet<T>();
        for (T o : set1) {
            if (!d.contains(o)) {
                symD.add(o);
            }
        }
        for (T o : set2) {
            if (!d.contains(o)) {
                symD.add(o);
            }
        }
        return symD;
    }
}
