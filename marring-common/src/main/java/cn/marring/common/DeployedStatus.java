package cn.marring.common;

public enum DeployedStatus {
    DISABLED("disabled", "不可用"),
    ENABLED("enabled", "可用");

    private String value;
    private String desc;

    DeployedStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getVlaue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}