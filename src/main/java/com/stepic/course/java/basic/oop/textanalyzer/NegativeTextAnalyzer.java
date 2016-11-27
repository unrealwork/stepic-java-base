package com.stepic.course.java.basic.oop.textanalyzer;


class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private static final String[] NEGATIVE_KEYWORDS = new String[]{":(", "=(", ":|"};

    public NegativeTextAnalyzer() {
    }

    @Override
    String[] getKeywords() {
        return NEGATIVE_KEYWORDS;
    }

    @Override
    Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
