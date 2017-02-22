package com.yfairy.demo.spring_in_action_2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * springbean 生命周期，生命周期实现这些接口，并会调用相关方法
 * 
 * @author jiangzi
 *
 */
public class BeanLifeCycle implements BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private String name;

	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.err.println("Bean的生命");
		System.out.println("bean初始化时调用实现ApplicationContextAware:setApplicationContext:" + applicationContext);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.err.println("Bean的生命");
		System.out.println("bean初始化时调用实现BeanFactoryAware:" + beanFactory);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(this.getClass().getName() + "调用destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.getClass().getName() + "调用afterPropertiesSet");
	}

	/*
	 * @Override public Object postProcessBeforeInitialization(Object bean,
	 * String beanName) throws BeansException {
	 * System.out.println(this.getClass().getName() +
	 * "postProcessBeforeInitialization"); return this; }
	 * 
	 * @Override public Object postProcessAfterInitialization(Object bean,
	 * String beanName) throws BeansException {
	 * System.out.println(this.getClass().getName() +
	 * "postProcessAfterInitialization"); return this; }
	 */

	@Override
	public String toString() {
		return "BeanLifeCycle [name=" + name + ", sex=" + sex + "]";
	}

}
