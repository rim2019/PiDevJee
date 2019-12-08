package model;

public class Car {
 public String Id;
 public String Brand;
 public int Year;
 public String Color;
 public int Price;
 public Boolean SoldState;
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getBrand() {
	return Brand;
}
public void setBrand(String brand) {
	Brand = brand;
}
public int getYear() {
	return Year;
}
public void setYear(int year) {
	Year = year;
}
public String getColor() {
	return Color;
}
public void setColor(String color) {
	Color = color;
}
public int getPrice() {
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
public Boolean getSoldState() {
	return SoldState;
}
public void setSoldState(Boolean soldState) {
	SoldState = soldState;
}
public Car(String id, String brand, int year, String color, int price, Boolean soldState) {
	super();
	Id = id;
	Brand = brand;
	Year = year;
	Color = color;
	Price = price;
	SoldState = soldState;
}
public Car() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
 
 
}
