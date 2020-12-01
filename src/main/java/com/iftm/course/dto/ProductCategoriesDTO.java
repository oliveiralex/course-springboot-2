package com.iftm.course.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.iftm.course.entities.Product;

public class ProductCategoriesDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Can't be empty")
	@Length(min = 3, max = 80, message = "Length must be between 3 and 80")
	private String name;
	
	@NotEmpty(message = "Can't be empty")
	@Length(min = 8, message = "Length must be greater than 8")
	private String description;
	
	@Positive(message = "Value must be greater than 0")
	private Double price;
	private String imgUrl;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductCategoriesDTO() {
	}

	public ProductCategoriesDTO(String name, String description, Double price, String imgUrl) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductCategoriesDTO(Product entity) {
		setName(entity.getName());
		setDescription(entity.getDescription());
		setPrice(entity.getPrice());
		setImgUrl(entity.getImgUrl());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
	
	public Product toEntity() {
		return new Product(null, name, description, price, imgUrl);
	}

}
