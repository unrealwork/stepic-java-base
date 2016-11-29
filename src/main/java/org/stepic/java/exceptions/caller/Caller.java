package org.stepic.java.exceptions.caller;


public class Caller {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        int size = stackTraceElements.length;
        StackTraceElement lastStackTraceElement = (size < 3) ? null : stackTraceElements[2];

        return (lastStackTraceElement == null) ?
                null :
                String.format("%s#%s", lastStackTraceElement.getClassName(), lastStackTraceElement.getMethodName());
    }
}
