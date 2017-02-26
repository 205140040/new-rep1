package com.yfairy.demo.spring_in_action_2;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanCounter implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Logger.getGlobal().info("BeanDefinitionCount:" + beanFactory.getBeanDefinitionCount());
	}

}
