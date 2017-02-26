package com.yfairy.demo.spring_in_action_2;

import java.beans.PropertyEditorSupport;

public class ParentEdit extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] ss = text.split("-");
		Parent parent = new Parent(ss[0], ss[1]);
		setValue(parent);
	}

}
