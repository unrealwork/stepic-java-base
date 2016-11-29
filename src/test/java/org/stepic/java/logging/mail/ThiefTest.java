package org.stepic.java.logging.mail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;


public class ThiefTest {
    private static final String TEMPLATE = "stones instead of %s";

    @DataProvider(name = "mailProvider")
    public Object[][] provideMail() {
        return new Object[][]{
                {4,
                        new MailPackage("a", "b", new Package("content", 10)),
                        new MailPackage("a", "b", new Package(String.format(TEMPLATE, "content"), 0))
                },
                {11,
                        new MailPackage("a", "b", new Package("content", 10)),
                        new MailPackage("a", "b", new Package("content", 10))
                },
                {10,
                        new MailPackage("a", "b", new Package("content", 10)),
                        new MailPackage("a", "b", new Package(String.format(TEMPLATE, "content"), 0))
                },
                {11,
                        new MailMessage("a", "b", "content"),
                        new MailMessage("a", "b", "content")
                },

        };
    }

    @Test(dataProvider = "mailProvider")
    public void testProcessMail(Integer minPrice, Sendable sentMail, Sendable recievedMail) throws Exception {
        MailService service = new Serivces.Thief(minPrice);
        assertEquals(service.processMail(sentMail), recievedMail);
    }


    @DataProvider(name = "mailSetProvider")
    private Object[][] provideMailSet() {
        return new Object[][]{
                {3,
                        new HashSet<Sendable>(Arrays.asList(
                                new MailMessage("a", "b", "mail"),
                                new MailPackage("a", "b", new Package("a", 1)),
                                new MailPackage("a", "b", new Package("a", 4)),
                                new MailPackage("a", "b", new Package("a", 3))
                        )
                        ),
                        7
                }
        };
    }

    @Test(dataProvider = "mailSetProvider")
    public void testGetStolenValue(Integer minPrice, Set<Sendable> mails, Integer expectedStolenValue) throws Exception {
        Serivces.Thief service = new Serivces.Thief(minPrice);
        for (Sendable mail : mails) {
            service.processMail(mail);
        }
        assertEquals(service.getStolenValue(), expectedStolenValue, 0);
    }

}