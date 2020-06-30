package cn.marring.api.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpException {
    private static final int DEFAULT_CODE = HttpStatus.BAD_REQUEST.value();
    private static final String DEFAULT_MSG = "Bad Request";

    public BadRequestException() {
        super(DEFAULT_CODE, DEFAULT_MSG);
    }

    public BadRequestException(String message) {
        super(DEFAULT_CODE, message);
    }
}
