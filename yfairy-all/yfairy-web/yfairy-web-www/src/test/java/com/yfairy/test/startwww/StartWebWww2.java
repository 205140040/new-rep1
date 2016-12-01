package com.yfairy.test.startwww;

import com.yfairy.common.jetty.StartJetty;

public class StartWebWww2 {
	public static void main(String[] args) {
		StartJetty.startJetty(8081, "/yfairy-web-www");
	}
}
