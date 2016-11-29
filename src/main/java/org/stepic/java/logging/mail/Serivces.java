package org.stepic.java.logging.mail;

import java.util.logging.Logger;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class Serivces {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {

        private static MailService[] services;
        private RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] services) {
            this.services = services;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService service : services) {
                if (service != null) {
                    service.processMail(mail);
                }
            }
            getRealMailService().processMail(mail);
            return mail;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }
    }

    public static class Spy implements MailService {
        private static final String SPECTIFIED_TEMPLATE =
                "Detected target mail correspondence: from %s to %s \"%s\"";
        private static final String DEFAULT_TEMPLATE =
                "Usual correspondence: from %s to %s";
        private Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) mail;
                if (AUSTIN_POWERS.equals(mailMessage.getFrom()) || AUSTIN_POWERS.equals(mailMessage.getTo())) {
                    String report = String.format(
                            SPECTIFIED_TEMPLATE,
                            mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()
                    );
                    logger.warning(report);
                } else {
                    String report = String.format(
                            DEFAULT_TEMPLATE,
                            mail.getFrom(), mail.getTo()
                    );
                    logger.info(report);
                }
            }

            return mail;
        }
    }

    public static class Thief implements MailService {
        private int minPrice;
        private int stolenValue;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
            stolenValue = 0;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                Package pack = mailPackage.getContent();
                if (pack.getPrice() >= minPrice) {
                    String newContent = String.format(
                            "stones instead of %s",
                            pack.getContent()
                    );
                    stolenValue += pack.getPrice();
                    Sendable newPackage = new MailPackage(
                            mailPackage.getFrom(), mailPackage.getTo(), new Package(newContent, 0)
                    );
                    return newPackage;
                }
            }
            return mail;
        }

        public int getStolenValue() {
            return stolenValue;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                String content = mailPackage.getContent().getContent();
                if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

}
