package cn.marring.api.jpa;

import lombok.Data;

/**
 * 返回单个数据结构
 * @param <T>
 */
@Data
public class SingleResult<T> extends CodeMsg {
    private T data;

    public SingleResult() {
        super();
    }

    public SingleResult(int code, String message) {
        super(code, message);
    }
}
