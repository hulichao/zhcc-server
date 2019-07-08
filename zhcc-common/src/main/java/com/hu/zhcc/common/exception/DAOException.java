package com.hu.zhcc.common.exception;

import org.springframework.http.HttpStatus;

/**
 * dao层异常
 *
 * Created by hulichao
 */
public class DAOException extends RuntimeException {

	private static final long serialVersionUID = -4537960897528403282L;

	private HttpStatus httpStatus;

	private int code;

	public DAOException(HttpStatus httpStatus, int code, String message) {
		this(message);
		this.httpStatus = httpStatus;
		this.code = code;
	}

	public DAOException(String message) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.code = 50000;
	}

	public DAOException(String message, int code, Exception e) {

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
