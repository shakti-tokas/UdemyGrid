package com.shakti.GridFrame.GridLogger;

/**
 * Created by stokas on 09-01-2016.
 */
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by stokas on 03-01-2016.
 * This is utility to Log every step in automation framework
 */
public class Log {

    // Initialize Log4J Logger
    private static Logger Log;
    private static final String log4jConfigPath = "E:\\GitHub\\UdemyGrid\\src\\main\\resources\\XML_Configs\\log4j.xml";

    public static void Initialize() {
        Log = Logger.getLogger(Log.class.getName());
        DOMConfigurator.configure(log4jConfigPath);
    }

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String TestCaseName){

        Log.info("**********************************************************************************************");

        Log.info("**********************************************************************************************");

        Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+TestCaseName+"       $$$$$$$$$$$$$$$$$$$$$$$$$");

        Log.info("**********************************************************************************************");

        Log.info("**********************************************************************************************");

    }

    //This is to print log for the ending of the test case

    public static void endTestCase(String TestCaseName){

        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-TEST-CASE-("+TestCaseName+")-ENDED-"+"             XXXXXXXXXXXXXXXXXXXXXX");

        Log.info("X");

        Log.info("X");

        Log.info("X");

        Log.info("X");

    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {

        Log.info(message);

    }

    public static void warn(String message) {

        Log.warn(message);

    }

    public static void error(String message) {

        Log.error(message);

    }

    public static void fatal(String message) {

        Log.fatal(message);

    }

    public static void debug(String message) {

        Log.debug(message);

    }
}