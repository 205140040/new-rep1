package com.yfairy.demo.spring_in_action_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class StudentDao extends JdbcDaoSupport {
	/**
	 * spring事务模板，通过编程方式使用事务
	 */
	private TransactionTemplate transactionTemplate;

	public List<People> listAllStudent() {
		String sql = "SELECT * FROM yf_student";
		RowMapper<People> rowMapper = new RowMapper<People>() {

			@Override
			public People mapRow(ResultSet rs, int rowNum) throws SQLException {
				People student = new People();
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
				return student;
			}

		};
		return getJdbcTemplate().query(sql, rowMapper);
	}

	public void addStudent(final String sql) {
		transactionTemplate.execute(new TransactionCallback<Integer>() {

			@Override
			public Integer doInTransaction(TransactionStatus status) {
				getJdbcTemplate().execute(sql);
				return null;
			}

		});
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}
