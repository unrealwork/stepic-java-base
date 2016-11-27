
class RoleParser {
    private static String printTextPerRole(String[] roles, String[] textLines) {
        java.util.Map<String, java.util.List<String>> resultMap = new java.util.HashMap<>();
        int i = 1;
        for (String text : textLines) {
            String[] splittedText = text.split(":", 2);
            if (splittedText.length == 2) {
                String newRoleText = String.format("%d)%s", i, splittedText[1]);
                String charachter = splittedText[0];
                java.util.List<String> roleTexts = resultMap.get(charachter);
                if (roleTexts == null) {
                    roleTexts = new java.util.LinkedList<>();
                }
                roleTexts.add(newRoleText);
                resultMap.put(charachter, roleTexts);
            } else {
                continue;
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String role : roles) {
            stringBuilder.append(String.format("%s:%n", role));
            for (String formattedText : resultMap.get(role)) {
                stringBuilder.append(String.format("%s%n", formattedText));
            }
            stringBuilder.append(String.format("%n"));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"
        };

        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
    }
}
