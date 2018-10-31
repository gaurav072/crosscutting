package com.startwithjava.crosscutting.logging.filter;

import com.startwithjava.crosscutting.logging.CentralLoggerImpl;
import com.startwithjava.crosscutting.logging.CorrelationIdDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Logger logger = LoggerFactory.getLogger(CentralLoggerImpl.class);
        String currentCorrId = request.getHeader(CorrelationIdDetail.CORRELATION_ID_HEADER);
            if (currentCorrId == null) {
                currentCorrId = UUID.randomUUID().toString();
                logger.info("No correlationId present in Header. Generated : " + currentCorrId);
            } else {
                logger.info("CorrelationId found in Header : " + currentCorrId);
            }
        MDC.put(CorrelationIdDetail.CORRELATION_ID_HEADER,currentCorrId);
        filterChain.doFilter(request, response);
    }
}