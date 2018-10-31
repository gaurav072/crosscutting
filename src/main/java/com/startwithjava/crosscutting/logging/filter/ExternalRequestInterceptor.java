package com.startwithjava.crosscutting.logging.filter;
import com.startwithjava.crosscutting.logging.CorrelationIdDetail;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import java.io.IOException;
public class ExternalRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) {
        HttpHeaders headers = request.getHeaders();
        headers.add(CorrelationIdDetail.CORRELATION_ID_HEADER, MDC.get(CorrelationIdDetail.CORRELATION_ID_HEADER));
        ClientHttpResponse clientHttpResponse = null;
        try {
            clientHttpResponse =  execution.execute(request, body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientHttpResponse;
    }
}