package com.yfairy.demo.jvm;

/**
 * 此代码演示了两点: 1.对象可以在被GC（垃圾回收时）自我拯救 2.这种自救的机会只有一次，因为一个对象的finalize方法最多只会被系统自动调用一次
 * 
 * @author jiangzi
 *
 */
public class FinalizeEscapeGC {

	public static FinalizeEscapeGC SAVE_HOOK = null;

	public void isAlive() {
		System.out.println("yes ,I am still alive");

	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();
		// 对象第一次拯救自救
		SAVE_HOOK = null;
		System.gc();
		// 因为finalize方法优先级很低，暂停一段时间等待它
		Thread.sleep(500);
		if (null != SAVE_HOOK) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no,已经被回收...");
		}
		System.out.println("----------------------------------");
		// 下面代码与上面的相同，但是这次失败了
		SAVE_HOOK = null;
		System.gc();
		// 因为finalize方法优先级很低，暂停一段时间等待它
		Thread.sleep(500);
		if (null != SAVE_HOOK) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no,已经被回收...");
		}
	}
}
