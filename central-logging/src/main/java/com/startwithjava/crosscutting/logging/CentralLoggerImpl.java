package com.startwithjava.crosscutting.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CentralLoggerImpl implements CentralLogger{
    private Logger logger = LoggerFactory.getLogger(CentralLoggerImpl.class);
    
    @Override
    public void info(String message, Object... args) {
        if(logger.isInfoEnabled()) {
            logger.info(message, args);
        }
    }

    @Override
    public void debug(String message, Object... args) {
        if(logger.isDebugEnabled()) {
            logger.debug(message, args);
        }
    }

    @Override
    public void error(String message, Throwable error, Object... args) {
        if(logger.isErrorEnabled()) {
            logger.error(message, error,args);
        }
    }

    @Override
    public void warn(String message, Object... args) {
        if(logger.isWarnEnabled()) {
            logger.warn(message, args);
        }
    }
}