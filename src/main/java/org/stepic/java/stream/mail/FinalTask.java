package org.stepic.java.stream.mail;


public class FinalTask {
    static interface Sendable<T> {
        String getFrom();

        String getTo();

        T getContent();
    }

    public static class MailBox<T> extends java.util.HashMap<String, java.util.List<T>> {
        @Override
        public java.util.List<T> get(Object key) {
            java.util.List<T> result = super.get(key);
            return (result == null) ? java.util.Collections.EMPTY_LIST : result;
        }
    }

    public static class MailMessage implements Sendable<String> {
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

    public static class MailService<T> implements java.util.function.Consumer<Sendable<T>> {
        private MailBox<T> mailBox;

        public MailService() {
            mailBox = new MailBox<T>();
        }


        public java.util.Map<String, java.util.List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(Sendable<T> sendable) {
            String key = sendable.getTo();
            java.util.List<T> mails = (mailBox.containsKey(key)) ? mailBox.get(key) : new java.util.LinkedList<>();
            mails.add(sendable.getContent());
            mailBox.put(key, mails);
        }
    }

    public static class Salary implements Sendable<Integer> {
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

    public static void main(String[] args) {
        // Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        java.util.List<MailMessage> messages = java.util.Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

// Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

// Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
        java.util.Map<String, java.util.List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                java.util.Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                java.util.Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(java.util.Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


// Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

// Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
        java.util.Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
        java.util.Map<String, java.util.List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(java.util.Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(java.util.Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(java.util.Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }
}
