package com.ascent.util;

public class FindPage {

	public int currentPage;				// ��ǰҳ��
	public int totalPage;				// ��ҳ��
	public int totalRows;				// �ܼ�¼��
	public int rowsPage = 10;			// ÿҳ��ʾ������
	public int firstRow;				// ��ʼ��ѯ�ļ�¼����
	
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
	
	//������Ҳ�����͵�ǰҳ��ʼ��¼������
	public void fPage(){
		firstRow = currentPage*rowsPage-rowsPage;
		totalPage = (totalRows+rowsPage-1)/rowsPage;
	}
}
