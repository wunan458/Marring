package cn.marring.api.configuration;

import cn.marring.api.exception.AlreadyExistsException;
import cn.marring.api.exception.ApiError;
import cn.marring.api.exception.BadRequestException;
import cn.marring.api.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionProcessor {

    // 200 数据已存在错误
    @ResponseBody
    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<ApiError> handleAlreadyExistsException(AlreadyExistsException e) {
        ApiError apiError = new ApiError(e.getCode(), e.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.OK);
    }

    // 404 Not Found
    // 数据不存在错误
    @ResponseBody
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(NotFoundException e) {
        ApiError apiError = new ApiError(e.getCode(), e.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.OK);
    }

    // 400 Bad Request
    // 数据参数错误
    @ResponseBody
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException e) {
        ApiError apiError = new ApiError(e.getCode(), e.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.OK);
    }
}
