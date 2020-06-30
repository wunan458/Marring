package cn.marring.api.jpa;

public enum DeleteStatus {
    YES("yes", "已删除"),
    NO("no", "未删除");

    private String value;
    private String desc;

    DeleteStatus(String value, String desc) {
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