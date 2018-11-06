package com.startwithjava.crosscutting.logging;

public interface CentralLogger {
    void info(String message, Object... args);
    void debug(String message,Object... args);
    void error(String message,Throwable error,Object... args);
    void warn(String message,Object... args);
}
