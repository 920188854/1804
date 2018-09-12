package com.jt.common.vo;

import java.util.List;

/**
 * 此类对象封装业务层数据
 * @author UID
 * @Description TODO
 * @param <T>
 */
public class PageObject<T> {

	/** 当前页的页码 */
	private Integer pageCurrent = 1;
	/** 总记录数 */
	private Integer rowCount = 0;
	/** 页面大小 */
	private Integer pageSize = 2;
	/** 总页数 */
	private Integer pageCount = 0;
	/** 当前页要显示的记录 */
	private List<T> records;

	public Integer getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
	
}
