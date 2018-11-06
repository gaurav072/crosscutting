package com.startwithjava.crosscutting.logging;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class CentralLog {
    private String message;
    private String correlationId;
    private String requestBody;
    private String responseBody;
    private Date requestTime;
    private float processingTime;
    private String ip;
    private String msInstance;
}
