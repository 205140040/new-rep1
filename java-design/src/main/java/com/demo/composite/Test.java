package com.demo.composite;

public class Test {

	public static void main(String[] args) throws Exception {
		Directory root = new Directory("root");

		Directory bin = new Directory("bin");
		Directory tmp = new Directory("tmp");
		root.add(bin);
		bin.add(tmp);
		bin.add(new File("f1", 1000));
		bin.add(new File("f2", 2000));
		root.printList();
		System.out.println("-------");
		tmp.add(new File("t1", 1600));
		tmp.add(new File("t2", 2500));
		root.printList();

	}

}
