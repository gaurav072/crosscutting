package com.startwithjava.crosscutting.logging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorrelationIdDetail {
    public static final String CORRELATION_ID_HEADER = "correlationId";
    private String correlationId;
    private CorrelationIdDetail parentCorrelationIdDetail;
}
