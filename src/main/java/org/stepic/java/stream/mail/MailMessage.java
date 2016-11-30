package org.stepic.java.stream.mail;

/**
 * Created by shmagrinskiy on 11/30/16.
 */
public class MailMessage implements Sendable<String> {
    private String from;
    private String to;
    private String content;

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }
}
