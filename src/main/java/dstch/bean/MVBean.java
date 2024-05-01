package main.java.dstch.bean;

public class MVBean {
	
	private int mainFoodType;
	private String orderType;
	private String searchKey;
	private double scrollVvalue;

	public MVBean(int mainFoodType, String orderType, String searchKey, double scrollVvalue) {
		this.mainFoodType = mainFoodType;
		this.orderType = orderType;
		this.searchKey = searchKey;
		this.scrollVvalue = scrollVvalue;
	}
	
	public int getMainFoodType() {
		return mainFoodType;
	}
	public void setMainFoodType(int mainFoodType) {
		this.mainFoodType = mainFoodType;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public double getScrollVvalue() {
		return scrollVvalue;
	}
	public void setScrollVvalue(double scrollVvalue) {
		this.scrollVvalue = scrollVvalue;
	}

}
