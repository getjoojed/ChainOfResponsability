
package com.mycompany.chainofresponsabilityexercise;

public abstract class AbstractLogger {
    
    public static int INFO = 1;
    public static int DEBUG = 1;
    public static int ERROR = 3;
    
    protected int level;
    
    //proximo elemento na Chain of Responsability
    protected AbstractLogger nextLogger;
    
    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }
    
    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }
    
    abstract protected void write(String message);
    
}
