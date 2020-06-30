package cn.marring.api.jpa;

public enum ReturnCode {
    SUCCESS(0, "success"),
    FAILED(1, "fail");

    private int code;
    private String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}