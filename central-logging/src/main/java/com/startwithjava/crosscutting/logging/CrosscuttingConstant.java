package com.startwithjava.crosscutting.logging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrosscuttingConstant {
    public static final String CORRELATION_ID_HEADER = "correlationId";
    public static final String REQUEST_DETAILS = "requestDetails";
    public static final String PREFIX_ENABLE_LOGGING= "central.logging";
    public static final String ENABLE = "enable";
}
