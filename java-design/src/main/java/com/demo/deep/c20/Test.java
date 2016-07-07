package com.demo.deep.c20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解:定义注解时需要一些元注解 元注解：
 * 
 * @target定义注解用于什么地方，（列入：一个类，或者方法，或者字段） @Retention表示需要在什么级别保存该注解信息，在源代码中source，
 *                                      类文件中class，运行时runtime
 * @documented 将此注解保存在javadoc中
 * @Inherited 允许子类继承父类中的注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	/**
	 * 注解中会包含某些元素表示某些值，注解的元素看起来就像接口的方法，唯一的区别是可以指定默认值
	 */
	String name();

	String description() default "描述";
	/**
	 * 注解元素包含：所有基本类型，string，class，enum，annotation 不允许使用任何包装类型
	 * 注解中添加了value（）元素时，使用时可以不用指定名称
	 */

}
