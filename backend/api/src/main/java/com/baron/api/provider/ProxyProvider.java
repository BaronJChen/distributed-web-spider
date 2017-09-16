package com.baron.api.provider;

import com.baron.backend.common.model.Proxy;

import java.util.List;

public interface ProxyProvider extends BaseProvider {
    Proxy getProxy();
    List<Proxy> getProxies(int num);
}