package com.demo.proxy;

public class Printer implements Printable{
	private String name;

	public Printer() {
		super();
		heavyJob("正在产生printer对象实例");
	}

	public Printer(String name) {
		super();
		this.name = name;
		heavyJob("正在产生printer对象实例[" + name + "]");
	}

	public void setPinterName(String name) {
		this.name = name;
	}

	public String getPinterName() {
		return name;
	}

	public void print(String string) {
		System.out.println("===name:" + name + "===");
		System.out.println(string);
	}

	private void heavyJob(String msg) {// 较繁忙的工作
		System.out.println(msg);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(".");
		}
		System.out.println("完成");
	}
}
