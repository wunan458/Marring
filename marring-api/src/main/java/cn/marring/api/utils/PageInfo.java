package cn.marring.api.utils;

import java.util.Collections;
import java.util.List;

/**
 * PageInfo
 * @author Wn 2020-05-19 17:11
 */
public class PageInfo<T> {
    /**
     * list
     */
    private List<T> lists;
    /**
     * total count
     */
    private Integer totalCount = 0;
    /**
     * page size
     */
    private Integer pageSize = 20;
    /**
     * current page
     */
    private Integer currentPage = 0;
    /**
     * pageNo
     */
    private Integer pageNo;

    /**
     * star
     */
    private int star;


    public PageInfo(Integer currentPage, Integer pageSize){
        if(currentPage==null){
            currentPage=1;
        }
        this.pageNo=(currentPage-1)*pageSize;
        this.pageSize=pageSize;
        this.currentPage=currentPage;
    }

    public Integer getStart() {
        return pageNo;
    }

    public void setStart(Integer start) {
        this.pageNo = start;
    }

    public Integer getTotalPage() {
        if (pageSize==null||pageSize == 0) {
            pageSize = 7;
        }
        if (this.totalCount % this.pageSize == 0) {
            return (this.totalCount / this.pageSize)==0?1:(this.totalCount / this.pageSize);
        }
        return (this.totalCount / this.pageSize + 1);
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public Integer getTotalCount() {
        if (totalCount==null) {
            totalCount = 0;
        }
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        if (pageSize==null||pageSize == 0) {
            pageSize = 7;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentPage() {
        if (currentPage==null||currentPage <= 0) {
            this.currentPage = 1;
        }
        return this.currentPage;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

}
