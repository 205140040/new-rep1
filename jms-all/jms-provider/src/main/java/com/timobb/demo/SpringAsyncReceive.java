package com.timobb.demo;

public class SpringAsyncReceive {
	/**
	 * 默认查找handleMessage 通过MessageListenerAdapter配置的消息异步消息监听器
	 * 
	 * @param message
	 */
	public void handleMessage(Object message) {
		/**
		 * 配置支持事务，出异常时不要捕获，系统会自动回滚
		 */
		System.out.println("异步收到的消息：message:" + message);
		//throw new RuntimeException("出异常了");
	}

}
