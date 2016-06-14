package com.demo.mediator;

import java.awt.Button;
import java.awt.HeadlessException;

public class ColleagueButton extends Button implements Colleague{
	/**
	 * @author admin
	 * 2016年6月14日
	 * @description 
	 */
	private static final long serialVersionUID = 1L;
	private Mediator mediator;
	

	public ColleagueButton(String label) throws HeadlessException {
		super(label);
	}

	public void setMediator(Mediator mediator) {
		this.mediator=mediator;
	}

	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}

}
