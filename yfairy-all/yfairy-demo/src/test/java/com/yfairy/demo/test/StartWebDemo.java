package com.yfairy.demo.test;

import com.yfairy.common.jetty.StartJetty;

public class StartWebDemo {

	public static void main(String[] args) {
		StartJetty.startJetty(8085, "/yfairy-demo");
	}

}
