package org.stepic.java.logging.mail;


public class UntrustworthyMailWorker implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        return null;
    }
}
