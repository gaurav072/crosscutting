package com.startwithjava.crosscutting.logging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

public class CentralLoggerImplTest {
    @Mock
    private Logger logger;
    @InjectMocks
    private CentralLoggerImpl centralLogger;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInfo_MessageisGiven_LogInfoMessage(){
        //Given
        String message = "INFO Message";
        String[] action = {"userLoggerIn"};
        when(logger.isInfoEnabled()).thenReturn(true);
        doNothing().when(logger).info(message,action);

        //When
        centralLogger.info(message,action);
        //Then
        verify(logger,Mockito.times(1)).isInfoEnabled();
        verify(logger,Mockito.times(1)).info(message,action);
    }
    @Test
    public void testWarn_MessageisGiven_LogWarnMessage(){
        //Given
        String message = "INFO Message";
        String[] action = {"userLoggerIn"};
        when(logger.isWarnEnabled()).thenReturn(true);
        doNothing().when(logger).warn(message,action);

        //When
        centralLogger.warn(message,action);
        //Then
        verify(logger,Mockito.times(1)).isWarnEnabled();
        verify(logger,Mockito.times(1)).warn(message,action);
    }
    @Test
    public void testError_MessageisGiven_LogErrorMessage(){
        //Given
        String message = "Error Message";
        Throwable ex = new Exception("Exception occured");
        Object args[]  = {};
        when(logger.isErrorEnabled()).thenReturn(true);
        doNothing().when(logger).error(message,ex,args);

        //When
        centralLogger.error(message,ex,args);
        //Then
        verify(logger,Mockito.times(1)).isErrorEnabled();
        verify(logger,Mockito.times(1)).error(message,ex,args);
    }
    @Test
    public void testDebug_MessageisGiven_LogDebugMessage(){
        //Given
        String message = "Error Message";
        Object args[]  = {};
        when(logger.isDebugEnabled()).thenReturn(true);
        doNothing().when(logger).debug(message,args);

        //When
        centralLogger.debug(message,args);
        //Then
        verify(logger,Mockito.times(1)).isDebugEnabled();
        verify(logger,Mockito.times(1)).debug(message,args);
    }
}
