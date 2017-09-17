package com.baron.api.feign;

import com.baron.backend.common.webmagic.Page;
import com.baron.backend.common.webmagic.Request;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("/dowloader/{downloader-name}")
public interface DownloaderFeignClient  {
    public Page download(@PathVariable("downloader-name") String providerName, @RequestBody Request request);
}
