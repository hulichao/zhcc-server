package com.hu.zhcc.common.exception;
import org.springframework.http.HttpStatus;

/**
 * @author hulichao
 * @date 2018/7/20
 */
public enum  ExceptionEnum {
    LOGIN_USERNAME_ERROR(40001, "登录失败，用户名不存在", HttpStatus.BAD_REQUEST),
    LOGIN_PASSWORD_ERROR(40002, "登录失败，密码错误", HttpStatus.BAD_REQUEST),

    RESOURCE_PERMISSSION_ERROR(40101, "没有权限，请联系管理员", HttpStatus.UNAUTHORIZED);
    private int code;
    private String msg;
    private HttpStatus httpStatus;

    ExceptionEnum(int code, String msg, HttpStatus status) {
        this.code = code;
        this.msg = msg;
        this.httpStatus = status;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
