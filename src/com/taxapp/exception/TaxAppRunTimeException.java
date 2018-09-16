package com.taxapp.exception;

/**
 * @author vaishnavi
 * 
 */
public class TaxAppRunTimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2255017340309220625L;

	/**
	 * 
	 */
	public TaxAppRunTimeException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public TaxAppRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public TaxAppRunTimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TaxAppRunTimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
