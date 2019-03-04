package util;

import java.util.List;
import java.util.Map;

import domain.Category;

public class Page {
	private List records;
	private int pageNum;   //当前页码
	private int pageSize=3;    //每页显示的条数
	private int totalRecords;  //总记录数
	private int totalPage;     //总页数
	private int startIndex;   //每页开始饿索引
	private String url;
	
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Page(int pageNum, int totalRecords) {
		super();
		this.pageNum = pageNum;
		this.totalRecords = totalRecords;
		//计算总页数
		totalPage=totalRecords%pageSize==0?totalRecords/pageSize:(totalRecords/pageSize+1);
		//计算每页开始索引
		startIndex=(pageNum-1)*pageSize;
	}
	
	

}
