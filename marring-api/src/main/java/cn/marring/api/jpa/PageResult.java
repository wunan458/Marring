package cn.marring.api.jpa;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> extends CodeMsg {

    private List<T> data;

    private int pages;

    private long total;
}
