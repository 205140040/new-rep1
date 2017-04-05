package com.yfairy.demo.mybatis3;

import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(Integer id);

	@Select("select * from yf_student where id=#{id}")
	Student selectByPrimaryKeyAnnotation(Integer id);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);
}