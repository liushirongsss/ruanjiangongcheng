package com.ascent.util;

public class FindPage {

	public int currentPage;				// 当前页数
	public int totalPage;				// 总页数
	public int totalRows;				// 总记录数
	public int rowsPage = 10;			// 每页显示多少行
	public int firstRow;				// 开始查询的记录索引
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	public int getRowsPage() {
		return rowsPage;
	}
	
	//计算总也数，和当前页开始记录的索引
	public void fPage(){
		firstRow = currentPage*rowsPage-rowsPage;
		totalPage = (totalRows+rowsPage-1)/rowsPage;
	}
}
