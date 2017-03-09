package com.yfairy.demo.spring_in_action_2;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Chapter13SpringWeb {

	public static void main(String[] args) {
		/**
		 * 第13章：处理web请求(352/505)<br>
		 * dispatcher 美[dɪsˈpætʃɚ]<br>
		 * n. 调度; 发报机; 收发;<br>
		 * 
		 * internal 英[ɪnˈtɜ:nl] <br>
		 * adj. 内部的; 国内的; 体内的; 内心的;<br>
		 * prep. （机构） 内部的;<br>
		 * 
		 */

		// 按照单例的编码规则，Servlet本身只是一个Java，结构并不是单例结构。
		// 只是Web容器在维护这些Servlet的时候只给创建一个实例存在JVM中，用户请求服务时，服务器只调用它已经实例化好的Servlet对象来处理请求。
		// 所以，告诉你的是Servlet并不是单例，只是容器让它只实例化一次，变现出来的是单例的效果而已。

		// 13.1开启springMVC之旅
		// 13.1.1请求生命中的一天
		// (1)DispatcherServlet作用是把所有的请求发送给spring的controller
		// DispatcherServlet
		// Model 模型数据

		// 13.1.2配置 DispatcherServlet
		// <servlet>
		// <servlet-name>spring-mvc</servlet-name>
		// <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		// <init-param>
		// <param-name>contextConfigLocation</param-name>
		// <param-value>classpath:spring-mvc.xml</param-value>
		// </init-param>
		// <load-on-startup>1</load-on-startup>
		// </servlet>
		// <servlet-mapping>
		// <servlet-name>spring-mvc</servlet-name>
		// <url-pattern>/</url-pattern>
		// </servlet-mapping>

		// 配置上下文载入器监听器,用于读取其他spring配置文件,

		// <!-- spring监听器 -->
		// <listener>
		// <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		// </listener>

		// 配置上下文载入器文件位置:
		// <context-param>
		// <param-name>contextConfigLocation</param-name>
		// <param-value>classpath:spring-context.xml</param-value>
		// </context-param>

		// 13.1.3 spring MVC概述(356/505)

		// 配置视图解析器，把modelandview中的逻辑视图解析为具体视图，返回
		// <!-- 配置spring 视图解析器 -->
		// <bean id="viewResovler"
		// class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		// <property name="prefix" value="/"></property>
		// <property name="suffix" value=".jsp"></property>
		// </bean>

		// 请求跳转:
		// org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:166)
		// : Forwarding to resource [/springInAction2Page.jsp] in
		// InternalResourceView 'springInAction2Page'

		// 请求过程:1.请求进入DispatcherServlet,2。DispatcherServlet通过BeanNameUrlHandlerMapping获得controller
		// 3.DispatcherServlet调用controller，4.返回ModelAndView通过InternalResourceViewResolver获得实际的返回页面
		// 5.DispatcherServlet通过InternalResourceView.renderMergedOutputModel完成跳转
		// InternalResourceView

		// 13.2将请求映射到控制器
		// SpringMvc中的所有映射器都实现了:HandlerMapping接口,
		// HandlerMapping
		// BeanNameUrlHandlerMapping 将控制器的名字(name)映射到url
		// SimpleUrlHandlerMapping 用配置文件中定义的集合映射到url
		// ControllerClassNameHandlerMapping
		//
		// <!-- 配置SimpleUrlHandlerMapping 管理url和controller -->
		// <bean id="simpleUrlHandlerMapping"
		// class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
		// <property name="mappings">
		// <props>
		// <prop key="/HomePage">homePageController</prop>
		// </props>
		// </property>
		// </bean>

		// 13.2.2 使用ControllerClassNameHandlerMapping

		// 可以为handerlMapping设置 <property name="order"
		// value="0"></property>，控制优先使用的映射器

		// 13.2.4使用多映射处理器

		// 13.3用控制器处理请求

		// 13.4处理异常
		// SimpleMappingExceptionResolver
		// 不起效
		// <!-- 配置异常解析器 -->
		// <bean id="simpleMappingExceptionResolver"
		// class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
		// <property name="exceptionMappings">
		// <props>
		// <prop key="java.lang.Exception">exceptionJsp</prop>
		// </props>
		// </property>
		// </bean>

	}

}
