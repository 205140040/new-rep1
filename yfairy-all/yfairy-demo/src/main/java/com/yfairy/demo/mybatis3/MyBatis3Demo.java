package com.yfairy.demo.mybatis3;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.alibaba.fastjson.JSON;

public class MyBatis3Demo {

	public static void main(String[] args) throws IOException {
		/**
		 * 官网(模块doc):http://blog.mybatis.org/p/products.html<br>
		 * 官网:http://www.mybatis.org/mybatis-3/zh/index.html<br>
		 * 
		 * 什么是 MyBatis ？ MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架。<br>
		 * MyBatis 避免了几乎所有的JDBC 代码和手动设置参数以及获取结果集。<br>
		 * MyBatis 可以对配置和原生Map使用简单的 XML 或注解，将接口和 Java 的<br>
		 * POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。<br>
		 */

		Logger.getGlobal().info("success...");

		// 从 XML 中构建 SqlSessionFactory

		// String mybatisConfigPath =
		// "com/yfairy/demo/mybatis3/mybatis-config.xml";
		// Resource resource = new ClassPathResource(mybatisConfigPath);
		// InputStream in = resource.getInputStream();
		// SqlSessionFactory sqlSessionFactory = new
		// SqlSessionFactoryBuilder().build(in);

		// 推荐使用xml配置文件构造SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = buildSqlSessionFactoryByXml();

		// 如果你更愿意直接从 Java 程序而不是 XML 文件中创建 configuration
		// SqlSessionFactory sqlSessionFactory = buildSqlSessionFactoryByCode();

		// 获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.selectByPrimaryKey(3);
		System.out.println(JSON.toJSONString(student));

		// 使用注解查询
		Student student2 = studentMapper.selectByPrimaryKeyAnnotation(2);
		System.out.println(JSON.toJSONString(student2));

		Student student3 = studentMapper.selectByPrimaryKey(5);
		System.out.println(JSON.toJSONString(student3));
		sqlSession.close(); // 关闭sqlSession

		// 作用域（Scope）和生命周期
		// SqlSessionFactoryBuilder
		// 一旦创建了SqlSessionFactory就不需要SqlSessionFactoryBuilder了

		// SqlSessionFactory
		// 提供sqlSession， return new DefaultSqlSession(configuration, executor,
		// autoCommit);
		// 该对象需要在应用使用期间一直存在

		// SqlSession
		// 每个线程都需要一个SqlSession
		// 每个线程都应该有它自己的 SqlSession 实例。SqlSession
		// 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。

		// 映射器实例（Mapper Instances）
		//
		// 映射器是创建用来绑定映射语句的接口。映射器接口的实例是从 SqlSession 中获得的。因此从技术层面讲，映射器实例的最大作用域是和
		// SqlSession 相同的，因为它们都是从 SqlSession 里被请求的。

		// 第2章：XML配置

		// <!-- 配置属性文件 -->
		// resource指定文件目录
		// <property name="password" value="root123" />直接在配置文件中设置property
		// <properties resource="jdbc.properties">
		// <property name="password" value="root123" />
		// </properties>

		// settings
		// 这是 MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为。
		// 下表描述了设置中各项的意图、默认值等。

		// <!-- 无论是 MyBatis 在预处理语句（PreparedStatement）中设置一个参数时， --> <br>
		// <!-- 还是从结果集中取出一个值时， 都会用类型处理器将获取的值以合适的方式转换成 --><br>
		// <!-- Java 类型。下表描述了一些默认的类型处理器。 --><br>
		// <typeHandlers><br>
		// <typeHandler handler="com.yfairy.demo.mybatis3.MyStringTypeHandler"
		// <br>
		// javaType="java.lang.String" jdbcType="VARCHAR" /> <br>
		// </typeHandlers> <br>
		// StringTypeHandler

		// 对象工厂（objectFactory）
		// MyBatis 每次创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成。
		// 默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认构造方法，要么在参数映射存在的时候通过参数构造方法来实例化。
		// 如果想覆盖对象工厂的默认行为，则可以通过创建自己的对象工厂来实现。比如：

		// 到插件 插件（plugins）

		// 插件（plugins）
		// MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
		//
		// Executor (update, query, flushStatements, commit, rollback,
		// getTransaction, close, isClosed)
		// ParameterHandler (getParameterObject, setParameters)
		// ResultSetHandler (handleResultSets, handleOutputParameters)
		// StatementHandler (prepare, parameterize, batch, update, query)

		// 映射器（mappers）
		// 既然 MyBatis 的行为已经由上述元素配置完了，我们现在就要定义 SQL 映射语句了。但是首先我们需要告诉 MyBatis
		// 到哪里去找到这些语句。 Java 在自动查找这方面没有提供一个很好的方法，所以最佳的方式是告诉 MyBatis
		// 到哪里去找映射文件。你可以使用相对于类路径的资源引用， 或完全限定资源定位符（包括 file:/// 的 URL），或类名和包名等。例如：

		// <!-- Using classpath relative resources -->
		// <mappers>
		// <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
		// <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
		// <mapper resource="org/mybatis/builder/PostMapper.xml"/>
		// </mappers>
		// <!-- Using url fully qualified paths -->
		// <mappers>
		// <mapper url="file:///var/mappers/AuthorMapper.xml"/>
		// <mapper url="file:///var/mappers/BlogMapper.xml"/>
		// <mapper url="file:///var/mappers/PostMapper.xml"/>
		// </mappers>
		// <!-- Using mapper interface classes -->
		// <mappers>
		// <mapper class="org.mybatis.builder.AuthorMapper"/>
		// <mapper class="org.mybatis.builder.BlogMapper"/>
		// <mapper class="org.mybatis.builder.PostMapper"/>
		// </mappers>
		// <!-- Register all interfaces in a package as mappers -->
		// <mappers>
		// <package name="org.mybatis.builder"/>
		// </mappers>
		// 这些配置会告诉了 MyBatis 去哪里找映射文件，剩下的细节就应该是每个 SQL 映射文件了，也就是接下来我们要讨论的。

	}

	// 从 XML 中构建 SqlSessionFactory
	private static SqlSessionFactory buildSqlSessionFactoryByXml() throws IOException {
		String mybatisConfigPath = "com/yfairy/demo/mybatis3/mybatis-config.xml";
		Resource resource = new ClassPathResource(mybatisConfigPath);
		InputStream in = resource.getInputStream();
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		return sqlSessionFactory;
	}

	// 如果你更愿意直接从 Java 程序而不是 XML 文件中创建 configuration
	private static SqlSessionFactory buildSqlSessionFactoryByCode() throws IOException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String password = "root123";
		DataSource dataSource = new PooledDataSource(driver, url, username, password);
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(StudentMapper.class);
		return new SqlSessionFactoryBuilder().build(configuration);
	}

}
