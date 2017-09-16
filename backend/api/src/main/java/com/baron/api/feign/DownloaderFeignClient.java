package com.baron.api.feign;

import com.baron.backend.common.model.Page;
import com.baron.backend.common.model.Request;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("/dowloader-provider/{provider-name}")
public interface DownloaderFeignClient  {
    public Page download(@PathVariable("provider-name") String providerName, @RequestBody Request request);
}
