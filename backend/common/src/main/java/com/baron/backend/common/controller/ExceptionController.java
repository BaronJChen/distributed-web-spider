package com.baron.backend.common.controller;

import com.baron.backend.common.dto.ResponseEntity;
import com.baron.backend.common.exception.ErrorCodes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/17 15:09
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Object handlerResponse(Throwable throwable) {
        return ResponseEntity.fail(ErrorCodes.UNKNOWN_ERROR, throwable.getMessage());
    }
}
