package com.yfairy.demo.spring_in_action_2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AdvanceBeanLifeCycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String beanName;

	private ApplicationContext applicationContext;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public Object postProcessBeforeInitialization(Object bean,
	 * String beanName) throws BeansException { // System.out.println(bean);
	 * return bean; }
	 */

	/*
	 * @Override public Object postProcessAfterInitialization(Object bean,
	 * String beanName) throws BeansException { // 在bean初始化之后设置修改bean的值
	 * 
	 * try { System.out.println(bean);
	 * System.out.println(bean.getClass().toString());
	 * 
	 * if (bean.getClass().toString().equals(AdvanceBeanLifeCycle.class.
	 * toString())) { Field field = bean.getClass().getDeclaredField("name");
	 * String val = (String) field.get(bean); field.setAccessible(true);
	 * field.set(bean, "修改后" + val); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * // System.out.println(bean); return bean; }
	 */

}
