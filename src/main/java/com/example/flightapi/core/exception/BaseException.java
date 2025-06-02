package com.example.flightapi.core.exception;

/**
 * BaseException
 * 
 * @author 
 */
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = -997101946070796354L;

	protected String code;

	protected Object[] args;

	public BaseException() {

	}

	public BaseException(String code, Object... args) {
		this.code = code;
		this.args = args;
	}

	public BaseException(Throwable e, String code, Object... args) {
		super(e);
		this.code = code;
		this.args = args;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}

}
