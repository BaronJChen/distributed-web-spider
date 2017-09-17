package com.baron.backend.common.webmagic;

import com.baron.backend.common.webmagic.Page;
import com.baron.backend.common.webmagic.Request;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Object contains extract results.<br>
 * It is contained in Page and will be processed in pipeline.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 * @see Page
 * @see com.baron.backend.common.webmagic.pipeline.Pipeline
 */
public class ResultItems {

    private Map<String, Object> fields = new LinkedHashMap<String, Object>();

    private Request request;

    private boolean skip;

    public <T> T get(String key) {
        Object o = fields.get(key);
        if (o == null) {
            return null;
        }
        return (T) fields.get(key);
    }

    public Map<String, Object> getAll() {
        return fields;
    }

    public <T> com.baron.backend.common.webmagic.ResultItems put(String key, T value) {
        fields.put(key, value);
        return this;
    }

    public Request getRequest() {
        return request;
    }

    public com.baron.backend.common.webmagic.ResultItems setRequest(Request request) {
        this.request = request;
        return this;
    }

    /**
     * Whether to skip the result.<br>
     * Result which is skipped will not be processed by Pipeline.
     *
     * @return whether to skip the result
     */
    public boolean isSkip() {
        return skip;
    }


    /**
     * Set whether to skip the result.<br>
     * Result which is skipped will not be processed by Pipeline.
     *
     * @param skip whether to skip the result
     * @return this
     */
    public com.baron.backend.common.webmagic.ResultItems setSkip(boolean skip) {
        this.skip = skip;
        return this;
    }

    @Override
    public String toString() {
        return "ResultItems{" +
                "fields=" + fields +
                ", request=" + request +
                ", skip=" + skip +
                '}';
    }
}
