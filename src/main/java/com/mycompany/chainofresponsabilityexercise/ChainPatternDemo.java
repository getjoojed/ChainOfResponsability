package com.mycompany.chainofresponsabilityexercise;

public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;

    }

    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "Isso é uma informação.");
        
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "Isso é uma informação de debug.");
        
        loggerChain.logMessage(AbstractLogger.ERROR,
                "Isso é uma informação de erro.");
        
    }

}
