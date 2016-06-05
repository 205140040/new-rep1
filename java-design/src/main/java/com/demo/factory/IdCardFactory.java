package com.demo.factory;

import java.util.ArrayList;
import java.util.List;

public class IdCardFactory extends Factory {
	private List<Object> owners = new ArrayList<Object>();

	@Override
	public Product createProduct(String owner) {
		return new IdCard(owner);
	}

	@Override
	public void regProduct(Product product) {
		this.owners.add(product);
	}

	public List<Object> getOwners() {
		return owners;
	}

	public void setOwners(List<Object> owners) {
		this.owners = owners;
	}

}
