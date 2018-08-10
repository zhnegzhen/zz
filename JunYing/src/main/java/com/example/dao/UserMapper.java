package com.example.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.models.User;
@Repository
public interface UserMapper {
	@Select("SELECT *FROM t_user where id=#{id}")
	  User getUserID(int id);

}
