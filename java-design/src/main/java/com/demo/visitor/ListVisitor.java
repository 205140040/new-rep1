package com.demo.visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {
	private String currentDir;// 当前目录所在文件夹

	@Override
	public void visit(File file) {
		System.out.println(currentDir + "/" + file);
	}

	@Override
	public void visit(Directory directory) {
		System.out.println(currentDir + "/" + directory);
		String saveDir = currentDir;
		currentDir = currentDir + "/" + directory.getName();
		Iterator<Entry> iterator;
		try {
			iterator = directory.iterator();
			while (iterator.hasNext()) {
				Entry entry = iterator.next();
				//访问者调用接收者，接收者内部又掉用访问者
				entry.accept(this);
			}
			currentDir = saveDir;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
