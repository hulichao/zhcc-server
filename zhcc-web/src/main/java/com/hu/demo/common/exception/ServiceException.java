package com.hu.demo.common.exception;

/**
 * service层异常
 * @author hulichao
 * @date 2018/3/15
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -8271985452908151156L;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
