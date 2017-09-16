package com.baron.backend.common.program;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 20:57
 */
@Configuration
public class ApplicationContextInitializer implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppContext.getAppContext().setApplicationContext(applicationContext);
    }
}
