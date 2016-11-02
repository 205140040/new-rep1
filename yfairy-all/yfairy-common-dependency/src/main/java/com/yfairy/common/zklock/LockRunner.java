package com.yfairy.common.zklock;

public class LockRunner implements Runnable{

	@Override
	public void run() {
		ZkExclusiveLock.exec("/usertender2");
	}

}
