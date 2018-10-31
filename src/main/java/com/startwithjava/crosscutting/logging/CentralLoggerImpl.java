package com.startwithjava.crosscutting.logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CentralLoggerImpl implements CentralLogger{
    @Value("${crosscutting.centralized.logLevel:INFO}")
    private Logger logger = LoggerFactory.getLogger(CentralLoggerImpl.class);
    private LogLevel logLevel;

    @Override
    public void info(String message, Object... args) {
        logger.info(message,args);
    }

    @Override
    public void debug(String message, Object... args) {
        logger.debug(message,args);
    }

    @Override
    public void error(String message, Throwable error, Object... args) {
        logger.error(message,args);
    }

    @Override
    public void warn(String message, Object... args) {
        logger.warn(message,args);
    }
}
