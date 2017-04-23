package com.yfairy.demo.mybatis3;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MybatisGeneratorDemo {

	public static void main(String[] args)
			throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		/**
		 * MyBatis Generator<br>
		 * 官网:http://www.mybatis.org/generator/<br>
		 * 
		 */
		// MyBatis生成器设计为在迭代开发环境中运行良好，并且可以作为Ant任务或Maven插件包含在连续构建环境中。运行MBG时重要的事项包括：
		//
		// 如果存在与新生成的XML文件名称相同的现有文件，MBG将自动合并XML文件。MBG不会覆盖您对其生成的XML文件所做的任何自定义更改。
		// 您可以一遍又一遍地运行它，而不用担心会丢失对XML的自定义更改。MBG将替换之前运行中生成的任何XML元素。
		// MBG
		// 不会合并Java文件，它可以覆盖现有文件或使用不同的唯一名称保存新生成的文件。如果您对生成的Java文件进行了更改并且以迭代方式运行MBG，则必须手动合并更改。当作为Eclipse
		// 插件运行时 ，MBG可以自动合并Java文件。

		/**
		 * 使用XML配置文件从Java运行MBG
		 */
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		String configFilePath = "com/yfairy/demo/mybatis3/generatorConfig.xml";
		Resource resource = new ClassPathResource(configFilePath);
		InputStream inputStream = resource.getInputStream();
		Configuration config = cp.parseConfiguration(inputStream);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		if (null != inputStream) {
			inputStream.close();
		}

		/**
		 * 运行MyBatis Generator后的任务
		 */

		// MyBatis Generator 详解
		// http://blog.csdn.net/isea533/article/details/42102297

		// 配置table中的runtimeSchema,实现动态指定包
		/**
		 * <pre>
		 * <table tableName="yf_blog_author" domainObjectName="BlogAuthor"
			enableSelectByExample="false" enableDeleteByExample="false"
			enableCountByExample="false" enableUpdateByExample="false"
			selectByExampleQueryId="false">
			<property name="runtimeSchema" value="author" />
		</table>
		 * </pre>
		 */

		// xml配置参考
		// <!-- 将数据库驱动配置到类路径中,可不配置该项 <classPathEntry location="" /> -->

		// <!-- 配置生成注释 -->
		// <commentGenerator
		// type="com.yfairy.demo.mybatis3.CommentGeneratorImpl">
		// <property name="suppressDate" value="false" />
		// <property name="suppressAllComments" value="false" />
		// <property name="addRemarkComments" value="true" />
		// </commentGenerator>

		// <!-- <jdbcConnection>元素用于指定表所需的数据库连接的属性。 MyBatis
		// Generator使用JDBC的DatabaseMetaData类来发现在配置中指定的表的属性。 -->
		// <jdbcConnection driverClass="com.mysql.jdbc.Driver"
		// connectionURL="jdbc:mysql://localhost:3306/test" userId="root"
		// password="">
		// </jdbcConnection>

		Logger.getGlobal().info("success...");
	}

}
