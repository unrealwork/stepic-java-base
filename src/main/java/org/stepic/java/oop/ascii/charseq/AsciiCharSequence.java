package org.stepic.java.oop.ascii.charseq;


import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private byte[] sequence;

    public AsciiCharSequence(byte[] sequence) {
        this.sequence = sequence;
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(sequence, start, end));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : sequence) {
            stringBuilder.append((char) b);
        }
        return stringBuilder.toString();
    }
}
