package com.baron.backend.common.dto;

import lombok.Data;

import javax.xml.ws.Response;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/17 15:11
 */
@Data
public class ResponseEntity<T> {
    private T data;
    private Boolean success;
    private String errorCode;
    public String errorMessage;

    public static <T> ResponseEntity<T> success(T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setData(data);
        responseEntity.setSuccess(true);

        return responseEntity;
    }

    public static ResponseEntity fail(String errorCode, String errorMessage) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(errorCode);
        responseEntity.setErrorMessage(errorMessage);

        return responseEntity;
    }
}