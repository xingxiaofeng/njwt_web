package com.njwtframework.web.common;

import java.io.Serializable;
import java.util.List;

/**
 * 
* @ClassName: Pager 
* @Description: TODO(分页公共类) 
* @author xxf xingxiaofeng2008_gmail_com 
* @date 2017年8月28日 下午9:33:28 
* 
* @param <T>
 */
public class Pager<T> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4542617637761955078L;

    /**
     * pageNumber 当前页
     */
    private int pageNumber = 1;
    /**
     * pageSize 每页大小
     */
    private int pageSize = 10;
    /**
     * pageTotal 总页数
     */
    private int pageTotal;
    /**
     * total 总条数
     */
    private int total = 0;
    /**
     * previousPage 前一页
     */
    private int previousPage;
    /**
     * nextPage 下一页
     */
    private int nextPage;
    /**
     * firstPage 第一页
     */
    private int firstPage = 1;
    /**
     * lastPage 最后一页
     */
    private int lastPage;
    /**
     * rows 每页的内容
     */
    private List<T> rows;

    // 以下set方式是需要赋值的
    /**
     * 设置当前页 <br>
     * 
     * @author kangxu
     * 
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * 设置每页大小,也可以不用赋值,默认大小为10条 <br>
     * 
     * @author kangxu
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 设置总条数,默认为0 <br>
     * 
     * @author kangxu
     * 
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
        otherAttr();
    }

    /**
     * 设置分页内容 <br>
     * 
     * @author kangxu
     * 
     * @param rows
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * 设置其他参数
     * 
     * @author kangxu
     * 
     */
    public void otherAttr() {
        // 总页数
        this.pageTotal = this.total % this.pageSize > 0 ? this.total / this.pageSize + 1 : this.total / this.pageSize;
        // 第一页
        this.firstPage = 1;
        // 最后一页
        this.lastPage = this.pageTotal;
        // 前一页
        if (this.pageNumber > 1) {
            this.previousPage = this.pageNumber - 1;
        } else {
            this.previousPage = this.firstPage;
        }
        // 下一页
        if (this.pageNumber < this.lastPage) {
            this.nextPage = this.pageNumber + 1;
        } else {
            this.nextPage = this.lastPage;
        }
    }

    // 放开私有属性
    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public int getTotal() {
        return total;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public List<T> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "Pager [pageNumber=" + pageNumber + ", pageSize=" + pageSize
                + ", pageTotal=" + pageTotal + ", total=" + total
                + ", previousPage=" + previousPage + ", nextPage=" + nextPage
                + ", firstPage=" + firstPage + ", lastPage=" + lastPage
                + ", rows=" + rows + "]";
    }
    
    

}