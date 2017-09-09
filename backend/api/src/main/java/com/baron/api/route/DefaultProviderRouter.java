package com.baron.api.route;

import com.baron.api.provider.BaseProvider;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@Component
public class DefaultProviderRouter implements ProviderRouter {
    private static final Logger logger =Logger.getLogger(DefaultProviderRouter.class);

    @Autowired
    HashMap<String, BaseProvider> baseProviders;

    @Override
    public <T> T route(String providerName, String methodName, Object[] args) {
        // 使用反射去调用相对应的方法
        BaseProvider baseProvider = baseProviders.get(providerName);

        if (baseProvider != null) {
            Class[] argsClasses = new Class[args.length];
            for (int i = 0, size = args.length; i < size; ++i) {
                argsClasses[i] = args[i].getClass();
            } // for

            try {
                Method method = baseProvider.getClass().getDeclaredMethod(methodName, argsClasses);
                method.setAccessible(true);
                return (T)method.invoke(baseProvider, args);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                logger.error(e);
            } // catch
        } // if

        return null;
    }
}
