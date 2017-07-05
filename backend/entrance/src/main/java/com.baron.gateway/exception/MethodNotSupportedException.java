package com.baron.gateway.exception;

import com.baron.gateway.program.AppConstants;

/**
 * Created by Baron.Chen on 2017/6/14.
 */
public class MethodNotSupportedException extends BusinessRuntimeException {
    public MethodNotSupportedException() {
        super(AppConstants.METHOD_NOT_SUPPORTED);
    }
}
