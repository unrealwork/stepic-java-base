package org.stepic.java.oop.textanalyzer;

/**
 * Created by shmagrinskiy on 11/27/16.
 */
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
