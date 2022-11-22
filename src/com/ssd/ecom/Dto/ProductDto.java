package com.ssd.ecom.Dto;

public class ProductDto {
//	`id` int NOT NULL AUTO_INCREMENT,
//	  `name` varchar(450) NOT NULL,
//	  `category` varchar(450) NOT NULL,
//	  `price` double NOT NULL,
//	  `image` 
	private int id;
	private String name;
	private String category;
	private Double price;
	private String image;
	public ProductDto(int id, String name, String category, Double price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}
	public ProductDto(String name, String category, Double price, String image) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}
	public ProductDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
				+ image + "]";
	}
	
	
	
}
