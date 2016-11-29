package org.stepic.java.oop.robot;


public final class SimpleRobot implements Robot {
    private Direction direction;
    private int x;
    private int y;


    public SimpleRobot() {
        direction = Direction.UP;
        x = 0;
        y = 0;
        if (direction != Direction.UP){

        }
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void turnLeft() {
        direction = Direction.getDirection(direction.getValue() + 1);
    }

    @Override
    public void turnRight() {
        direction = Direction.getDirection(direction.getValue() - 1);
    }

    @Override
    public void stepForward() {
        final int value = direction.getValue();
        if (value % 2 == 0) {
            x += (value - 1);
        } else {
            y += (value - 2);
        }
    }

    public static void moveRobot(final Robot robot, int toX, int toY) {
        int startX = robot.getX();
        int startY = robot.getY();

        Direction direction = (startY > toY) ? Direction.DOWN : Direction.UP;

        while (robot.getDirection() != direction) robot.turnLeft();
        while (robot.getY() != toY) {
            robot.stepForward();
        }
        direction = (startX > toX) ? Direction.LEFT : Direction.RIGHT;

        while (robot.getDirection() != direction) robot.turnLeft();
        while (robot.getX() != toX) {
            robot.stepForward();
        }
    }

    public static void main(String[] args) {
        Robot robot = new SimpleRobot();
        moveRobot(robot, 3, 0);
        System.out.println(String.format("(%d, %d)", robot.getX(), robot.getY()));
        moveRobot(robot, 0, 3);
        System.out.println(String.format("(%d, %d)", robot.getX(), robot.getY()));
        moveRobot(robot, -3, 0);
        System.out.println(String.format("(%d, %d)", robot.getX(), robot.getY()));
        moveRobot(robot, 0, -3);
        System.out.println(String.format("(%d, %d)", robot.getX(), robot.getY()));
    }
}
