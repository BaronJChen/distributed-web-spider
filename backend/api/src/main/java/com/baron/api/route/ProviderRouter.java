package com.baron.api.route;

public interface ProviderRouter {
    <T> T route(String providerName, String methodName, Object[] args);
}
