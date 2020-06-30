package cn.marring.api.jpa;

import lombok.Data;

@Data
public class CodeMsg {
    private int code;
    private String message;

    public CodeMsg() {
        this.code = ReturnCode.SUCCESS.getCode();
        this.message = ReturnCode.SUCCESS.getMsg();
    }

    public CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }
}