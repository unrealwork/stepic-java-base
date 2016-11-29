package org.stepic.java.oop.robot;


public interface Robot {

    Direction getDirection();

    int getX();

    int getY();

    void turnLeft();

    void turnRight();

    void stepForward();
}
