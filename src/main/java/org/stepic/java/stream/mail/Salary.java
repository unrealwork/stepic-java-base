package org.stepic.java.stream.mail;

/**
 * Created by shmagrinskiy on 11/30/16.
 */
public class Salary implements Sendable<Integer> {
    private String to;
    private String from;
    private Integer salary;

    public Salary(String from, String to, Integer salary) {
        this.to = to;
        this.from = from;
        this.salary = salary;
    }

    @Override
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return salary;
    }
}
