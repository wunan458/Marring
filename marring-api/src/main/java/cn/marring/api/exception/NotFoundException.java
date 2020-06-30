package cn.marring.api.exception;


import org.springframework.http.HttpStatus;

/**
 * 自定义异常, 没找到异常
 */
public class NotFoundException extends HttpException {
    private static final int DEFAULT_CODE = HttpStatus.NOT_FOUND.value();
    private static final String DEFAULT_MSG = "resource_not_found";

    public NotFoundException() {
        super(DEFAULT_CODE, DEFAULT_MSG);
    }

    public NotFoundException(String message) {
        super(DEFAULT_CODE, message);
    }
}
