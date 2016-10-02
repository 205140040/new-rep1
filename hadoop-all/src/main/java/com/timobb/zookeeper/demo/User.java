package com.timobb.zookeeper.demo;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String path;

	private String name;
	
	

	public User() {
		super();
	}
	
	

	public User(String path, String name) {
		super();
		this.path = path;
		this.name = name;
	}



	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [path=" + path + ", name=" + name + "]";
	}

}
