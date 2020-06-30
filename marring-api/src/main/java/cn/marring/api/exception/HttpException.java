package cn.marring.api.exception;

import lombok.Data;

/**
 * 自定义异常, http code msg
 */
@Data
public class HttpException extends Exception {

    final int code;
    final String message;

    private static final int DEFAULT_CODE = 200;
    private static final String DEFAULT_MSG = "Internal Server Error.";

    public HttpException(String message) {
        this.code = DEFAULT_CODE;
        this.message = message;
    }

    public HttpException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
