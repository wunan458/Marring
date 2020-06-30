package cn.marring.api.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义异常, 已存在异常
 */
public class AlreadyExistsException extends HttpException {
    private static final int DEFAULT_CODE = HttpStatus.ALREADY_REPORTED.value();
    private static final String DEFAULT_MSG = "already_exists";

    public AlreadyExistsException() {
        super(DEFAULT_CODE, DEFAULT_MSG);
    }

    public AlreadyExistsException(String message) {
        super(DEFAULT_CODE, message);
    }
}
