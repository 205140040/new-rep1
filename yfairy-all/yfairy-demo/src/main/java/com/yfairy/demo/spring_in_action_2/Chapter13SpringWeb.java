package com.yfairy.demo.spring_in_action_2;

import org.springframework.web.servlet.DispatcherServlet;

public class Chapter13SpringWeb {

	public static void main(String[] args) {
		/**
		 * 第13章：处理web请求(352/505)<br>
		 * dispatcher 美[dɪsˈpætʃɚ]<br>
		 * n. 调度; 发报机; 收发;<br>
		 * 
		 */

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
		
		//13.1.3 spring MVC概述(356/505)
		
	}

}
