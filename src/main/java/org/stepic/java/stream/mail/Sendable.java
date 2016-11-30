package org.stepic.java.stream.mail;

/**
 * Created by shmagrinskiy on 12/1/16.
 */
interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}
