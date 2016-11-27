package com.stepic.course.java.basic.oop.textanalyzer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by shmagrinskiy on 11/27/16.
 */
public class TextAnlyzers {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }

    abstract class KeywordAnalyzer implements TextAnalyzer {
        @Override
        public Label processText(String text) {
            for (String keyword : getKeywords()) {
                if (text.contains(keyword)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }

        protected abstract String[] getKeywords();

        protected abstract Label getLabel();
    }

    class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
        private final String[] NEGATIVE_KEYWORDS = new String[]{":(", "=(", ":|"};

        public NegativeTextAnalyzer() {
        }

        @Override
        protected String[] getKeywords() {
            return NEGATIVE_KEYWORDS;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    public class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            super();
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            return (text.length() <= maxLength) ? Label.OK : Label.TOO_LONG;
        }
    }

    @DataProvider(name = "textAnalyzerTextProvider")
    public Object[][] provideTextAnalyzerText() {
        return new Object[][]{
                {
                        new SpamAnalyzer(new String[]{"first", "second"}),
                        "this is third test, and it is not spam",
                        Label.OK
                }
        };
    }

    @Test(dataProvider = "textAnalyzerTextProvider")
    public void testCheckLabels(TextAnalyzer analyzer, String text, Label expectedLabel) {
        assertEquals(analyzer.processText(text), expectedLabel);
    }
}
