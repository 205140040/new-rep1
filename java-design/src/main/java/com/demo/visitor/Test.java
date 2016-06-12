package com.demo.visitor;

public class Test {

	public static void main(String[] args) {
		try {
			Directory root = new Directory("root");
			Directory bin = new Directory("bin");
			Directory tmp = new Directory("tmp");
			root.add(bin);
			bin.add(new File("b1", 100));
			bin.add(new File("b2", 200));
			bin.add(tmp);
			tmp.add(new File("t1", 300));
			tmp.add(new File("t2", 500));
			root.accept(new ListVisitor());
			new File("t2", 500).accept(new ListVisitor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
