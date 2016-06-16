package com.demo.proxy;

public class PrinterProxy implements Printable {

	private String name; // 命名

	private Printer real;// 本人

	public PrinterProxy() {
		super();
	}

	public PrinterProxy(String name) {
		super();
		this.name = name;
	}

	public void setPinterName(String name) {
		if (null != real) {
			real.setPinterName(name);
		}
		this.name = name;
	}

	public String getPinterName() {
		return name;
	}

	public void print(String string) {
		relize(); // 产生本人
		real.print(string); // 使用本人的pint
	}

	private synchronized void relize() {// 产生本人
		if (null == real) {
			real = new Printer();
		}
	}

}
