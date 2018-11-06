package com.startwithjava.crosscutting.logging.filter;

import com.startwithjava.crosscutting.logging.CentralLoggerImpl;
import com.startwithjava.crosscutting.logging.CrosscuttingConstant;
import com.startwithjava.crosscutting.logging.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
@ConditionalOnProperty(prefix = CrosscuttingConstant.PREFIX_ENABLE_LOGGING, name = CrosscuttingConstant.ENABLE)
public class CentralLoggerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Logger logger = LoggerFactory.getLogger(CentralLoggerImpl.class);
        String currentCorrId = request.getHeader(CrosscuttingConstant.CORRELATION_ID_HEADER);
            if (currentCorrId == null) {
                currentCorrId = UUID.randomUUID().toString();
                logger.info("No correlationId present in Header. Generated : " + currentCorrId);
            } else {
                logger.info("CorrelationId found in Header : " + currentCorrId);
            }
        MDC.put(CrosscuttingConstant.CORRELATION_ID_HEADER,currentCorrId);
        MDC.put(CrosscuttingConstant.REQUEST_DETAILS, RequestUtil.getRequestBodyAsString(request));
        filterChain.doFilter(request, response);
    }

}