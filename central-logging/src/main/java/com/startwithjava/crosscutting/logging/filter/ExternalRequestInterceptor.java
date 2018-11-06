package com.startwithjava.crosscutting.logging.filter;

import com.startwithjava.crosscutting.logging.CentralLogger;
import com.startwithjava.crosscutting.logging.CentralLoggerFactory;
import com.startwithjava.crosscutting.logging.CrosscuttingConstant;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@ConditionalOnProperty(prefix = CrosscuttingConstant.ENABLE_LOGGING, name = "enable")
public class ExternalRequestInterceptor implements ClientHttpRequestInterceptor {
    private CentralLogger centralLogger = CentralLoggerFactory.getLogger();
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) {
        HttpHeaders headers = request.getHeaders();
        headers.add(CrosscuttingConstant.CORRELATION_ID_HEADER, MDC.get(CrosscuttingConstant.CORRELATION_ID_HEADER));
        ClientHttpResponse clientHttpResponse = null;

        try {
            clientHttpResponse =  execution.execute(request, body);
            centralLogger.info("External Call with headers",headers,new String(body));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientHttpResponse;
    }
}