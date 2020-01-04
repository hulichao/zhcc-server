package com.hu.zhcc.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 客户端异常类, CustomException
 *
 * @author hulichao
 * @date 2018/7/20
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -2499344353634158686L;

    private HttpStatus httpStatus;

    private int code;

    public CustomException(HttpStatus httpStatus, int code, String message) {
        this(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public CustomException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = 50000;
    }

    public CustomException(String message, int code, Exception e) {

        super(message, e.getCause());
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int state) {
        this.code = code;
    }
}
