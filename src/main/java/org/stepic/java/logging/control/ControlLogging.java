package org.stepic.java.logging.control;

import java.util.logging.*;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class ControlLogging {
    private static void configureLogging() {
        // your implementation here
        final String ClassAName = "org.stepic.java.logging.ClassA";
        final String ClassBNAme = "org.stepic.java.logging.ClassB";
        final String packageNAme = "org.stepic.java";
        final Logger loggerA = Logger.getLogger(ClassAName);
        final Logger loggerB = Logger.getLogger(ClassBNAme);
        final Logger loggerPackage = Logger.getLogger(packageNAme);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        loggerA.setLevel(Level.ALL);
        loggerB.setLevel(Level.WARNING);
        loggerPackage.setUseParentHandlers(false);
        loggerPackage.addHandler(handler);
    }
}
