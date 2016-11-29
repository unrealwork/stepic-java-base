package org.stepic.java.exceptions.robot;

/**
 * Created by shmagrinskiy on 11/28/16.
 */
public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
