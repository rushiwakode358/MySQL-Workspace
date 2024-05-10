package com.TCL;

public class Product {
	
	private int productId;
	private String productBrand;
	private String productModel;
	private double productPrice;
	
	public Product() {
		
	}

	public Product(int productId, String productBrand, String productModel, double productPrice) {
		super();
		this.productId = productId;
		this.productBrand = productBrand;
		this.productModel = productModel;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productBrand=" + productBrand + ", productModel=" + productModel
				+ ", productPrice=" + productPrice + "]";
	}
}
