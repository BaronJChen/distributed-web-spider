package com.baron.backend.common.util;

import com.baron.backend.common.program.CommonContext;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 2017/6/13.
 */
public class SpringUtil {
    private SpringUtil() {
    }

    public static ApplicationContext getApplicationContext() {
        return CommonContext.getCommonContext().getApplicationContext();
    }

    public static <T> T getBean(Class<T> clazz) {
        ApplicationContext context = getApplicationContext();
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name) {
        ApplicationContext context = getApplicationContext();
        return (T) context.getBean(name);
    }

    public static <T> List<T> getBeans(Class<T> clazz) {
        ApplicationContext context = getApplicationContext();
        Map<String, T> beanMap = context.getBeansOfType(clazz);
        List<T> beans = new ArrayList<>();

        beans.forEach(bean -> beans.add(bean));
        return beans;
    }

    public static List<Object> getBeans(List<String> names) {
        ApplicationContext context = getApplicationContext();
        List<Object> beans = new ArrayList<>();
        names.forEach(name -> beans.add(context.getBean(name)));
        return beans;
    }
}
