package com.demo.iterator;

/**
 * 书架
 * 
 * @author admin 2016年6月2日
 * @description
 * @ClassName BookShelf
 */
public class BookShelf implements Aggregate {

	private Book[] books;

	private int last = 0;

	public BookShelf(Integer maxSize) {
		this.books = new Book[maxSize];
	}

	public Book getBookAt(int index) {
		return books[index];
	}

	public void appendBook(Book book) {
		books[last] = book;
		last++;
	}

	public int getLenght() {
		return last;
	}

	public Iterator iterator() {
		return new BookShelfIterator(this);
	}

}
