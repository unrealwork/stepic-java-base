package org.stepic.java.stream.mail;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MailBox<T> extends HashMap<String, List<T>> {
    @Override
    public List<T> get(Object key) {
        List<T> result = super.get(key);
        return (result == null) ? Collections.EMPTY_LIST : result;
    }
}
