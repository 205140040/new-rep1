package com.demo.template;

public class TemplateTest {

	public static void main(String[] args) {
		AbstractDisplay charDis = new CharDisplay('a');
		charDis.display();
		AbstractDisplay stringDis = new StringDisplay("hello");
		stringDis.display();
	}

}
