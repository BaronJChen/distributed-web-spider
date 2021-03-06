package com.baron.entrance.downloader;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.baron.backend.common.webmagic.downloader.HttpClientDownloader;

/**
 * Created by Baron.Chen on 2017/6/15.
 */
@Component
@Scope("prototype")
public class DefaultDownloader extends HttpClientDownloader {
}
