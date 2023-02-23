package main.java.dstch.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CLBean {

	private final SimpleIntegerProperty num;
	private final SimpleStringProperty name;
	private final SimpleStringProperty item1;
	private final SimpleStringProperty item2;
	private final SimpleStringProperty item3;
	private final SimpleStringProperty item4;
	
	public CLBean(int num, String name, String item1, String item2, String item3, String item4){
		this.num = new SimpleIntegerProperty(num);
		this.name = new SimpleStringProperty(name);
		this.item1 = new SimpleStringProperty(item1);
		this.item2 = new SimpleStringProperty(item2);
		this.item3 = new SimpleStringProperty(item3);
		this.item4 = new SimpleStringProperty(item4);
	}
	
	public int getNum() {
		return this.num.get();
	}
	public String getName() {
		return this.name.get();
	}
	public String getItem1() {
		return this.item1.get();
	}
	public String getItem2() {
		return this.item2.get();
	}
	public String getItem3() {
		return this.item3.get();
	}
	public String getItem4() {
		return this.item4.get();
	}
	
	public void setNum(int num) {
		this.num.set(num);
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public void setItem1(String item1) {
		this.item1.set(item1);
	}
	public void setItem2(String item2) {
		this.item2.set(item2);
	}
	public void setItem3(String item3) {
		this.item3.set(item3);
	}
	public void setItem4(String item4) {
		this.item4.set(item4);
	}
	
	public SimpleIntegerProperty getNumProperty() {
		return num;
	}
	public SimpleStringProperty getNameProperty() {
		return name;
	}
	public SimpleStringProperty getItem1Property() {
		return item1;
	}
	public SimpleStringProperty getItem2Property() {
		return item2;
	}
	public SimpleStringProperty getItem3Property() {
		return item3;
	}
	public SimpleStringProperty getItem4Property() {
		return item4;
	}
	
}
