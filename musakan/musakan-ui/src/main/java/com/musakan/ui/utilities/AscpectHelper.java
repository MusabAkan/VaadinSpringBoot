package com.musakan.ui.utilities;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AscpectHelper {
    /**
     * Core Aspect için kullanılan bir sınıf
     * @param exception
     */
    @AfterThrowing(pointcut = "execution(* com.musakan.core..*(..))", throwing = "exception")
    public void handleServiceException(Exception exception) {
        NotificationHelper.showError(exception.getMessage());
    }

    /**
     * UI Aspect için kullanılan bir sınıf
     * @param exception
     */
    @AfterThrowing(pointcut = "execution(* com.musakan.ui..*(..))", throwing = "exception")
    public void handleUIViewException(Exception exception) {
        NotificationHelper.showError(exception.getMessage());
    }
}