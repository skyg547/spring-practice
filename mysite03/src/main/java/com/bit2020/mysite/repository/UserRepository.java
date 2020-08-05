package com.bit2020.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2020.mysite.exception.UserRepositoryException;
import com.bit2020.mysite.vo.UserVo;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private DataSource dataSource;

	public boolean save(UserVo vo) {

		int count = sqlSession.insert("user.save", vo);

		return count == 1;
	}

	public UserVo findByNo(Long no) throws UserRepositoryException {
		UserVo result = sqlSession.selectOne("user.findByNo", no);
		return result;
	}

	public UserVo findByEmailAndPassWord(UserVo vo) {
		/*
		 * Map<String,Object> map = new HashMap<K, V>(); map.put("email",);
		 */
		UserVo result = sqlSession.selectOne("user.findByEmailAndPassword", vo);

		return result;
	}

	public void update(UserVo vo) {
		// TODO Auto-generated method stub
		int count = sqlSession.update("user.update", vo);

		}

}
