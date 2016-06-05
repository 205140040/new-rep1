package com.demo.factory;

public abstract class Factory {
	public final Product createInstance(String owner) {
		Product product = createProduct(owner);
		regProduct(product);
		return product;
	}

	/**
	 * 创建产品
	 * 
	 * @author admin
	 * @date 2016年6月5日
	 * @description
	 * @param owner
	 * @return Product
	 */
	public abstract Product createProduct(String owner);

	/**
	 * 注册产品
	 * 
	 * @author admin
	 * @date 2016年6月5日
	 * @description
	 * @param product
	 *            void
	 */
	public abstract void regProduct(Product product);
}
