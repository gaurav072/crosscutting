package com.startwithjava.crosscutting.logging;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = CrosscuttingConstant.PREFIX_ENABLE_LOGGING, name = CrosscuttingConstant.ENABLE)
public class LogAspect {

}
