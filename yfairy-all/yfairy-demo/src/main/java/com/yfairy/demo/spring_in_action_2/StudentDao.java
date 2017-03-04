package com.yfairy.demo.spring_in_action_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StudentDao extends JdbcDaoSupport {

	public List<People> listAllStudent() {
		String sql = "SELECT * FROM yf_student";
		RowMapper<People> rowMapper = new RowMapper<People>() {

			@Override
			public People mapRow(ResultSet rs, int rowNum) throws SQLException {
				People student = new People();
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				return student;
			}

		};
		return getJdbcTemplate().query(sql, rowMapper);
	}

}
