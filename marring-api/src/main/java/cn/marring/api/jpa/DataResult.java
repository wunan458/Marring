package cn.marring.api.jpa;

import lombok.Data;

import java.util.List;

@Data
public class DataResult<T> extends CodeMsg {

    private List<T> data;

    public DataResult() {
        super();
    }

    public DataResult(int code, String message) {
        super(code, message);
    }
}
