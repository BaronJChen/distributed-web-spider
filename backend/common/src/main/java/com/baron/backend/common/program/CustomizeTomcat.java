package com.baron.backend.common.program;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * Created by Baron.Chen on 2017/6/3.
 */
@Component
public class CustomizeTomcat implements EmbeddedServletContainerCustomizer {
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//        configurableEmbeddedServletContainer.setContextPath("/api");
    }
}
