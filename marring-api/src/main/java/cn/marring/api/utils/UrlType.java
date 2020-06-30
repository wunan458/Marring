package cn.marring.api.utils;

public enum UrlType {
    MODEL(0, "model file"),
    SDK(1, "skd file");

    private int code;
    private String msg;

    UrlType(int code, String msg) {
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
