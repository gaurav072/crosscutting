package com.startwithjava.crosscutting.logging;

public class CentralLoggerFactory {
    private static CentralLogger logger=new CentralLoggerImpl();
    public static CentralLogger getLogger(){
       return logger;
    }
}
