package com.yfairy.demo.spring_in_action_2;

public class Child1 extends Parent {

	private String child1No;

	public String getChild1No() {
		return child1No;
	}

	public void setChild1No(String child1No) {
		this.child1No = child1No;
	}

	@Override
	public String toString() {
		return "Child1 [child1No=" + child1No + ", getName()=" + getName() + ", getSex()=" + getSex() + "]";
	}

}
