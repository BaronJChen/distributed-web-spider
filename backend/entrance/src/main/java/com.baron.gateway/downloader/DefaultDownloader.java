package com.baron.gateway.downloader;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

/**
 * Created by Baron.Chen on 2017/6/15.
 */
@Component
@Scope("prototype")
public class DefaultDownloader extends HttpClientDownloader {
}
