package com.yfairy.demo.effective_java;

public class ProductBuilder {

	private String name;

	private String address;

	private String productTime;

	private Integer limitTime;

	private Integer baozhiqi;

	private String companyName;

	private String companyTel;

	private String companyOwner;

	public static ProductBuilder buildProduct() {
		return new ProductBuilder();
	}

	public ProductBuilder name(String name) {
		this.name = name;
		return this;
	}

	public ProductBuilder address(String address) {
		this.address = address;
		return this;
	}

	public ProductBuilder productTime(String productTime) {
		this.productTime = productTime;
		return this;
	}

	public ProductBuilder companyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public ProductBuilder companyTel(String companyTel) {
		this.companyTel = companyTel;
		return this;
	}

	public ProductBuilder companyOwner(String companyOwner) {
		this.companyOwner = companyOwner;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductTime() {
		return productTime;
	}

	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}

	public Integer getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Integer limitTime) {
		this.limitTime = limitTime;
	}

	public Integer getBaozhiqi() {
		return baozhiqi;
	}

	public void setBaozhiqi(Integer baozhiqi) {
		this.baozhiqi = baozhiqi;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getCompanyOwner() {
		return companyOwner;
	}

	public void setCompanyOwner(String companyOwner) {
		this.companyOwner = companyOwner;
	}

	@Override
	public String toString() {
		return "ProductBuilder [name=" + name + ", address=" + address + ", productTime=" + productTime + ", limitTime="
				+ limitTime + ", baozhiqi=" + baozhiqi + ", companyName=" + companyName + ", companyTel=" + companyTel
				+ ", companyOwner=" + companyOwner + "]";
	}

	public static void main(String[] args) {
		/**
		 * 遇到多个构造器参数时，考虑用构建器(构建器可以动态构建任意类型参数的对象)
		 */
		ProductBuilder product1 = ProductBuilder.buildProduct().name("辣条1").address("美国1");
		System.out.println(product1);

		ProductBuilder product2 = ProductBuilder.buildProduct().name("辣条2").address("美国2").companyName("食品公司")
				.companyTel("40004555").companyOwner("张三");
		System.out.println(product2);
	}
}
