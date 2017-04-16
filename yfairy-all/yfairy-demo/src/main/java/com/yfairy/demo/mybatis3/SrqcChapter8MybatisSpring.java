package com.yfairy.demo.mybatis3;

import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SrqcChapter8MybatisSpring {

	public static void main(String[] args) {
		/**
		 * 第8章：mybatis-spring(180/272)<br>
		 * (官网)http://www.mybatis.org/spring/zh/sample.html<br>
		 */
		SqlSession sqlSession = null;
		try {
			// Connection connection = null;
			// Savepoint sp = connection.setSavepoint();
			// connection.commit();
			//
			// sqlSession = SqlSessionFactoryUtil.openSqlSession();
			// BlogTitleMapper blogTitleMapper =
			// sqlSession.getMapper(BlogTitleMapper.class);
			//
			// BlogTitle search = new BlogTitle();
			// // search.setId(5);
			// search.setIdList(Arrays.asList(1, 2, 5, 6));
			// List<BlogTitle> sbt =
			// blogTitleMapper.listBlogTitleWithCon(search);
			// System.err.println(JSON.toJSONString(sbt));

			System.err.println("----------------------mybatis-srping----------------------------------");

			// 8.1.3 spring事务管理
			// DataSourceTransactionManager

			// 8.2 mybatis-spring 应用

			// TODO 8.2.2 配置
			// ,通过SqlSessionFactoryBean配置SqlSessionFactory(193/272)
			// SqlSessionFactoryBean

			/**
			 * 
			 * 配置 mybatis SqlSessionFactoryBean 获得 sqlSessionFactory <br>
			 * <bean id="sqlSessionFactory" class=
			 * "org.mybatis.spring.SqlSessionFactoryBean"><br>
			 * <!-- 设置mybatis配置文件，也可以不设置 --> <br>
			 * <property name="configLocation" <br>
			 * value="classpath:com/yfairy/demo/mybatis3/mybatis-config-spring.xml"></property>
			 * <br>
			 * <!-- 设置数据源 --> <br>
			 * <property name="dataSource" ref="dataSource"></property> <br>
			 * <!-- 配置,当 MyBatis 映射器 XML 文件在和映射器类相同的路径下不存在,指定 扫描 *.xml配置文件 -->
			 * <br>
			 * <!-- mapperLocations 属性使用一个资源位置的 list。 这个属性可以用来指定 MyBatis 的 XML
			 * 映射器文件的位置。 <br>
			 * 它的值可以包含 Ant 样式来加载一个目录中所有文件, 或者从基路径下 递归搜索所有路径。比如: --> <br>
			 * <property name="mapperLocations" <br>
			 * value="classpath*:com/yfairy/demo/mybatis3/*Mapper.xml"></property>
			 * <br>
			 * </bean> <br>
			 * 
			 */

			// 在spring中，实现了FactoryBean接口的类，通过getObject 获得 工厂类 创建的类

			// 要注意 SqlSessionFactoryBean 实现了 Spring 的 FactoryBean 接口(请参考 Spring
			// 文 档的 3.8 章节)这就说明了由 Spring 最终创建的 bean 不是 SqlSessionFactoryBean 本身,
			// 。 而是工厂类的 getObject()返回的方法的结果。这种情况下,Spring 将会在应用启动时为你 创建
			// SqlSessionFactory 对象,然后将它以 SqlSessionFactory 为名来存储

			// 到 SqlSessionTemplate ,mybatis-spring中的核心类

			// SqlSessionTemplate
			// SqlSessionTemplate 是 MyBatis-Spring 的核心。 这个类负责管理 MyBatis 的
			// SqlSession, 调用 MyBatis 的 SQL 方法, 翻译异常。 SqlSessionTemplate 是线程安全的,
			// 可以被多个 DAO 所共享使用。
			//
			// 当调用 SQL 方法时, 包含从映射器 getMapper()方法返回的方法, SqlSessionTemplate
			// 将会保证使用的 SqlSession 是和当前 Spring 的事务相关的。此外,它管理 session 的生命
			// 周期,包含必要的关闭,提交或回滚操作。
			//
			// SqlSessionTemplate 实现了 SqlSession 接口,这就是说,在代码中无需对 MyBatis 的
			// SqlSession 进行替换。 SqlSessionTemplate 通常是被用来替代默认的 MyBatis 实现的
			// DefaultSqlSession , 因为模板可以参与到 Spring 的事务中并且被多个注入的映射器类所使
			// 用时也是线程安全的。相同应用程序中两个类之间的转换可能会引起数据一致性的问题。
			//
			// SqlSessionTemplate 对象可以使用 SqlSessionFactory 作为构造方法的参数来创建。

			// 8.2.4 配置mapper ，生成动态代理mapper

			// 为了代替手工使用 SqlSessionDaoSupport 或 SqlSessionTemplate 编写数据访问对象
			// (DAO)的代码,MyBatis-Spring 提供了一个动态代理的实现:MapperFactoryBean。这个类
			// 可以让你直接注入数据映射器接口到你的 service 层 bean 中。当使用映射器时,你仅仅如调 用你的 DAO
			// 一样调用它们就可以了,但是你不需要编写任何 DAO 实现的代码,因为 MyBatis-Spring 将会为你创建代理。
			//
			// 使用注入的映射器代码,在 MyBatis,Spring 或 MyBatis-Spring 上面不会有直接的依赖。
			// MapperFactoryBean 创建的代理控制开放和关闭 session,翻译任意的异常到 Spring 的
			// DataAccessException 异常中。此外,如果需要或参与到一个已经存在活动事务中,代理将 会开启一个新的 Spring
			// 事务。
			//
			// MapperFactoryBean
			// 数据映射器接口可以按照如下做法加入到 Spring 中:
			//
			// <bean id="userMapper"
			// class="org.mybatis.spring.mapper.MapperFactoryBean">
			// <property name="mapperInterface"
			// value="org.mybatis.spring.sample.mapper.UserMapper" />
			// <property name="sqlSessionFactory" ref="sqlSessionFactory" />
			// </bean>

			// 8.2.4.2 MapperScannerConfigurer 自动扫描mapper，生成mapper代理类

			// MapperScannerConfigurer
			// 没有必要在 Spring 的 XML 配置文件中注册所有的映射器。相反,你可以使用一个
			// MapperScannerConfigurer , 它 将 会 查 找 类 路 径 下 的 映 射 器 并 自 动 将 它 们 创
			// 建 成 MapperFactoryBean。
			//
			// 要创建 MapperScannerConfigurer,可以在 Spring 的配置中添加如下代码:
			//
			// <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
			// <property name="basePackage"
			// value="org.mybatis.spring.sample.mapper" />
			// </bean>
			// basePackage 属性是让你为映射器接口文件设置基本的包路径。 你可以使用分号或逗号
			// 作为分隔符设置多于一个的包路径。每个映射器将会在指定的包路径中递归地被搜索到。

			ApplicationContext context = new ClassPathXmlApplicationContext(
					"com/yfairy/demo/mybatis3/mybatis-spring.xml");
			BlogTitleDao blogTitleDao = context.getBean(BlogTitleDao.class);
			BlogTitle search = new BlogTitle();
			// search.setId(5);
			search.setIdList(Arrays.asList(1, 2, 5, 6));
			blogTitleDao.listBlogTitleWithCon(search);

			System.out.println();
			System.err.println("使用MapperFactoryBean 生成 mapper 动态代理类");
			System.out.println();
			blogTitleDao.listBlogTitleUseMapperFactoryBean(search);

			// sqlSession.commit(); // 提交事务
		} catch (Exception e) {
			e.printStackTrace();
			// sqlSession.rollback();
		} finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}
	}

}
