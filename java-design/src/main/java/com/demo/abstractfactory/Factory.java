package com.demo.abstractfactory;

public abstract class Factory {
	public static <T> Factory getFactory(Class<T> clazz) {
		Factory factory = null;
		try {
			factory = (Factory) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return factory;
	}

	public abstract Link createLink(String capation, String url);

	public abstract Tray createTray(String capation);

	public abstract Page createPage(String title, String author);

}
