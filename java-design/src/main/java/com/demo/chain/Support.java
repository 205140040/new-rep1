package com.demo.chain;

public abstract class Support {
	private String name;// 问题解决者的名称
	private Support next;// 问题转送者

	public Support(String name) { // 产生问题解决者
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Support setNext(Support next) {// 设置转送者
		this.next = next;
		return next;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}

	public abstract boolean resolve(Trouble trouble); // 解决问题的方法

	public final void support(Trouble trouble) {// 解决问题的步骤
		if (resolve(trouble)) {
			done(trouble);
		} else if (null != next) {
			next.support(trouble);
		} else {
			fail(trouble);
		}

	}

	public void done(Trouble trouble) { // 已解决
		System.out.println(trouble + "is resolved" + this);
	}

	public void fail(Trouble trouble) {
		System.out.println(trouble + "问题尚未解决");
	}
}
