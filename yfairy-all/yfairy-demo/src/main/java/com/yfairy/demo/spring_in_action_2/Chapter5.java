package com.yfairy.demo.spring_in_action_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Chapter5 {

	private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";

	private static final String username = "root";

	private static final String password = "root123";

	public static void main(String[] args) {
		/**
		 * 第5章：使用数据库(125/505)<br>
		 * 5.1spring的数据访问哲学<br>
		 * DAO(Data Access Object) 数据访问对象是一个面向对象的数据库接口<br>
		 * 5.1.1了解spring数据访问的异常体系<br>
		 * java 中SQLException<br>
		 * spring中sql异常,都继承自DataAccessException<br>
		 * 到5.2：配置数据源(130/505)<br>
		 */
		// SQLException
		// CannotAcquireLockException

		// 5.1.2数据访问的模板化<br>
		// spring常用数据访问模板:JdbcTemplate,HibernateTemplate,SqlMapClientTemplate(ibatis)

		// 5.1.3使用dao支持类,JdbcDaoSupport,HibernateDaoSupport
		// JdbcTemplate
		// JdbcDaoSupport
		// HibernateDaoSupport

		// 5.2配置数据源
		// 5.2.2使用数据源连接池
		// BasicDataSource

		// 5.3在spring里使用jdbc
		// 5.3.2使用jdbc模板

		// 使用my自定义的jdbc模板
		MyJdbcTemplate myJdbcTemplate = new MyJdbcTemplate(url, username, password);
		String sql = "SELECT * FROM yf_student where id=1 ";
		People people = new People();
		System.out.println("name:" + people.getName() + "\tsex:" + people.getSex());
		myJdbcTemplate.executeQuery(sql, new IJdbcTemplateCallBack() {

			@Override
			public <T> void executeQueryCallBack(ResultSet resultSet, Object object) {
				People p = (People) object;
				try {
					while (resultSet.next()) {
						p.setName(resultSet.getString("name"));
						p.setSex(resultSet.getString("sex"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}, people);
		System.out.println("name:" + people.getName() + "\tsex:" + people.getSex());

		// 5.3.2使用jdbc模板
		String xmlfileStr = "com\\yfairy\\demo\\spring_in_action_2\\spring-demo.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(xmlfileStr);
		BasicDataSource dataSource = (BasicDataSource) context.getBean("dataSource");
		// JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		System.err.println("------------------------------------");
		System.out.println(jdbcTemplate);
		RowMapper<People> rowMapper = new RowMapper<People>() {

			@Override
			public People mapRow(ResultSet rs, int rowNum) throws SQLException {
				People people = new People();
				people.setName(rs.getString("name"));
				people.setSex(rs.getString("sex"));
				return people;
			}

		};

		// 查询
		String psql = "SELECT * FROM yf_student where id=? ";
		List<People> plList = jdbcTemplate.query(psql, new Object[] { 2 }, rowMapper);

		People p2 = plList.get(0);
		System.out.println("name:" + p2.getName() + "\tsex:" + p2.getSex());

		// 修改
		String updsql = "update yf_student set name=? where id=? ";
		jdbcTemplate.update(updsql, new Object[] { "露露", 3 });

		List<People> plList2 = jdbcTemplate.query(psql, new Object[] { 3 }, rowMapper);
		People p3 = plList2.get(0);
		System.out.println("name:" + p3.getName() + "\tsex:" + p3.getSex());

		// 5.3.3使用spring对jdbc的dao支持类
		// 如果程序里有很多dao，需要jdbc模板，可以设置一个父dao，注入jdbc模板，让其他dao都继承该父类
		// 比如可继承JdbcDaoSupport
		System.out.println("-------------------------------------------");
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		List<People> peoples = studentDao.listAllStudent();
		for (People p : peoples) {
			System.out.println("name:" + p.getName() + "\tsex:" + p.getSex());
		}

		// 5.4在spring中集成hibernate (143/505)

		// 5.6 spring和ibatis
		// SqlSessionFactoryBean
		// SqlSessionTemplate
		// SqlSessionDaoSupport
		System.err.println("---------------spring和ibatis------------------");
		// 必须配置映射xml文件
		// SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate)
		// context.getBean("sqlSessionTemplate");
		// String batisSql="SELECT * FROM yf_student where id=3 ";
		// Map<Object, Object> rmap=sqlSessionTemplate.selectMap(batisSql, "a");
		// System.out.println(rmap);

		// System.out.println("name:" + mbP.getName() + "\tsex:" +
		// mbP.getSex());
		
		//5.7 缓存
		

	}

}
