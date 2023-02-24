package main.java.dstch.bean;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class FIBean {
	
	private final SimpleIntegerProperty num;
	private final SimpleStringProperty name;
	private final SimpleStringProperty type;
	private final SimpleFloatProperty degree;
	private final SimpleObjectProperty<Image> image;
	private final SimpleFloatProperty hunger;
	private final SimpleFloatProperty sanity;
	private final SimpleFloatProperty health;
	private final SimpleIntegerProperty qualityTime;
	private final SimpleStringProperty comment;
	
	public FIBean(int num, String name, String type, float degree,
				  Image image, float hunger, float sanity, float health, 
				  int qualityTime, String comment){
		this.num = new SimpleIntegerProperty(num);
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
		this.degree = new SimpleFloatProperty(degree);
		this.image = new SimpleObjectProperty<Image>(image);
		this.hunger = new SimpleFloatProperty(hunger);
		this.sanity = new SimpleFloatProperty(sanity);
		this.health = new SimpleFloatProperty(health);
		this.qualityTime = new SimpleIntegerProperty(qualityTime);
		this.comment = new SimpleStringProperty(comment);
	}
	
	public int getNum() {
		return this.num.get();
	}
	public String getName() {
		return this.name.get();
	}
	public String getType() {
		return this.type.get();
	}
	public float getDegree() {
		return this.degree.get();
	}
	public Image getImage() {
		return this.image.get();
	}
	public float getHunger() {
		return this.hunger.get();
	}
	public float getSanity() {
		return this.sanity.get();
	}
	public float getHealth() {
		return this.health.get();
	}
	public int getQualityTime() {
		return this.qualityTime.get();
	}
	public String getComment() {
		return this.comment.get();
	}
	
	public void setNum(int num) {
		this.num.set(num);
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public void setType(String type) {
		this.type.set(type);
	}
	public void setDegree(float degree) {
		this.degree.set(degree);
	}
	public void setImage(Image image) {
		this.image.set(image);
	}
	public void setHunger(float hunger) {
		this.hunger.set(hunger);
	}
	public void setSanity(float sanity) {
		this.sanity.set(sanity);
	}
	public void setHealth(float health) {
		this.health.set(health);
	}
	public void setQualityTime(int qualityTime) {
		this.qualityTime.set(qualityTime);
	}
	public void setComment(String comment) {
		this.comment.set(comment);
	}

	public SimpleIntegerProperty getNumProperty() {
		return num;
	}
	public SimpleStringProperty getNameProperty() {
		return name;
	}
	public SimpleStringProperty getTypeProperty() {
		return type;
	}
	public SimpleFloatProperty getDegreeProperty() {
		return degree;
	}
	public SimpleObjectProperty<Image> getImageProperty() {
		return image;
	}
	public SimpleFloatProperty getHungerProperty() {
		return hunger;
	}
	public SimpleFloatProperty getSanityProperty() {
		return sanity;
	}
	public SimpleFloatProperty getHealthProperty() {
		return health;
	}
	public SimpleIntegerProperty getQualityTimeProperty() {
		return qualityTime;
	}
	public SimpleStringProperty getCommentProperty() {
		return comment;
	}

}
