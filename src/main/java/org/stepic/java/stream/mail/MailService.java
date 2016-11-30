package org.stepic.java.stream.mail;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public class MailService<T> implements Consumer<Sendable<T>> {
    private MailBox<T> mailBox;

    public MailService() {
        mailBox = new MailBox<T>();
    }


    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> sendable) {
        String key = sendable.getTo();
        List<T> mails = (mailBox.containsKey(key)) ? mailBox.get(key) : new LinkedList<>();
        mails.add(sendable.getContent());
        mailBox.put(key, mails);
    }
}
