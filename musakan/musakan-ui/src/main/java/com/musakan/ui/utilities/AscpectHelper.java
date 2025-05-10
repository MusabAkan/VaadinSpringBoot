package com.musakan.ui.utilities;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AscpectHelper {
    @AfterThrowing(pointcut = "execution(* com.musakan.core..*(..))", throwing = "exception")
    public void handleServiceException(Exception exception) {
        NotificationHelper.showWarning(exception.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* com.musakan.ui..*(..))", throwing = "exception")
    public void handleUIViewException(Exception exception) {
        NotificationHelper.showWarning(exception.getMessage());
    }
}