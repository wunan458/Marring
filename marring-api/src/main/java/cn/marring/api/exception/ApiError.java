package cn.marring.api.exception;

import cn.marring.api.jpa.CodeMsg;
import lombok.Data;

/**
 * http error api
 */
@Data
public class ApiError extends CodeMsg {

    private static final int DEFAULT_CODE = 1;
    private static final String DEFAULT_MSG = "Internal Server Error.";

    public ApiError(int code, String message) {
        super(code, message);
    }
}
