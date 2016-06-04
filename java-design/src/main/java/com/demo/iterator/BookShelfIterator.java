package com.demo.iterator;

public class BookShelfIterator implements Iterator {

	private BookShelf bookShelf;

	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		super();
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	/**
	 * 判断是否进行迭代
	 */
	public Boolean hasNext() {
		if (index < bookShelf.getLenght()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 把循环变量推到下一个
	 */
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
