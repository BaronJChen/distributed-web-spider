package com.baron.entrance.downloader;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.baron.backend.common.webmagic.Page;
import com.baron.backend.common.webmagic.Request;
import com.baron.backend.common.webmagic.Task;
import com.baron.backend.common.webmagic.downloader.HttpClientDownloader;
import com.baron.backend.common.webmagic.selector.PlainText;

/**
 * Created by Jason on 2017/6/12.
 */
@Component
@Scope("prototype")
public class SeleniumDownloader extends HttpClientDownloader {
    private static final Logger logger = Logger.getLogger(SeleniumDownloader.class);

    @Override
    public Page download(Request request, Task task) {
//        String url = request.getUrl();
//        WebDriver driver = null;
//        String content = null;
//        try {
//            driver = driverPool.get();
//        } catch (InterruptedException e) {
//            logger.error(e);
//        } // catch
//
//        try {
//            driver.get(url);
//            content = driver.findElement(By.xpath("/html")).getAttribute("outerHTML");
//        } finally {
//            if (driver != null) {
//                driverPool.returnToPool(driver);
//            } // if
//        } // try
//
//        Page page = new Page();
//        page.setRawText(content);
//        page.setRequest(request);
//        page.setUrl(new PlainText(url));
//        return page;
        return null;
    }
}
