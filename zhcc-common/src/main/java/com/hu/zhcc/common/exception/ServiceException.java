package com.hu.zhcc.common.exception;

import org.springframework.http.HttpStatus;

/**
 * service层异常
 * @author hulichao
 * @date 2018/3/15
 */
public class ServiceException extends RuntimeException {


	private HttpStatus httpStatus;
	private int code;
	public ServiceException(HttpStatus httpStatus, int code, String message) {
		this(message);
		this.httpStatus = httpStatus;
		this.code = code;
	}

	public ServiceException(String message) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.code = 50000;
	}

	public ServiceException(String message, int code, Exception e) {

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
