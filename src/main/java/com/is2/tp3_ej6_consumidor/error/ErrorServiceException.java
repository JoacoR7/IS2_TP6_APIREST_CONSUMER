package com.is2.tp3_ej6_consumidor.error;

public class ErrorServiceException extends Exception{
	public ErrorServiceException() {}
	
	public ErrorServiceException(String msg) {
        super(msg);
    }
}
