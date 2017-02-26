package com.yfairy.demo.spring_in_action_2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AdvanceBeanLifeCycle implements BeanPostProcessor {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// System.out.println(bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// 在bean初始化之后设置修改bean的值
		/*
		 * try { System.out.println(bean);
		 * System.out.println(bean.getClass().toString());
		 * 
		 * if (bean.getClass().toString().equals(AdvanceBeanLifeCycle.class.
		 * toString())) { Field field =
		 * bean.getClass().getDeclaredField("name"); String val = (String)
		 * field.get(bean); field.setAccessible(true); field.set(bean, "修改后" +
		 * val); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		// System.out.println(bean);
		return bean;
	}

}
