package com.stepic.course.java.basic.oop.textanalyzer;


abstract class KeywordAnalyzer implements TextAnalyzer {
    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(text)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    abstract String[] getKeywords();

    abstract Label getLabel();
}
