package com.cg.obs.exception;

public class BankException extends Exception{

	String msg;
	public BankException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public BankException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BankException(String arg0) {
		super(arg0);
		this.msg = arg0;
	}

	public BankException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BankException [msg=" + msg + "]";
	}

}
