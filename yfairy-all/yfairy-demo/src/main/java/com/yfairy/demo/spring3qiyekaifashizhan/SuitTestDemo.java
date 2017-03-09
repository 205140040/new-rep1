package com.yfairy.demo.spring3qiyekaifashizhan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 多个类打包测试
 * @author jiangzi
 *
 */
@RunWith(value=Suite.class) //指定打包测试运行器
@SuiteClasses(value={MoneyTest.class,Test2.class}) //指定要运行的测试用例
public class SuitTestDemo {

}
