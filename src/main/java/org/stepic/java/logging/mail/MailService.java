package org.stepic.java.logging.mail;

interface MailService {
    Sendable processMail(Sendable mail);
}