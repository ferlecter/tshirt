package br.com.tshirt.service.Exception;

public class BusinessException extends Exception {

    public BusinessException() {
        super();
    }


    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message,Throwable  cause ) {
        super(message,cause);
    }
}
