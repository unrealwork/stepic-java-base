package org.stepic.java.oop.robot;


enum Direction {
    UP(1),
    DOWN(3),
    LEFT(2),
    RIGHT(0);

    private int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Direction getDirection(int value) {
        switch (value % 4) {
            case 1:
                return UP;
            case 2:
                return RIGHT;
            case 3:
                return DOWN;
            default:
                return RIGHT;
        }
    }
}
