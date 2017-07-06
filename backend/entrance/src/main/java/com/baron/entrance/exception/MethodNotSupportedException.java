package com.baron.entrance.exception;

import com.baron.entrance.program.AppConstants;

/**
 * Created by Baron.Chen on 2017/6/14.
 */
public class MethodNotSupportedException extends BusinessRuntimeException {
    public MethodNotSupportedException() {
        super(AppConstants.METHOD_NOT_SUPPORTED);
    }
}
