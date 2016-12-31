package com.yfairy.demo.javacore;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 400;

	public SimpleFrame() throws HeadlessException {
		super();
		setSize(WIDTH, HEIGHT);
	}

}
