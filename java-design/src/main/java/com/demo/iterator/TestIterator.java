package com.demo.iterator;

public class TestIterator {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(5);
		bookShelf.appendBook(new Book("a"));
		bookShelf.appendBook(new Book("b"));
		bookShelf.appendBook(new Book("c"));
		bookShelf.appendBook(new Book("d"));
		bookShelf.appendBook(new Book("e"));
		Iterator iterator = bookShelf.iterator();
		while (iterator.hasNext()) {
			Book next = (Book) iterator.next();
			System.out.println("bookName:" + next.getBookName());
		}

	}
}
