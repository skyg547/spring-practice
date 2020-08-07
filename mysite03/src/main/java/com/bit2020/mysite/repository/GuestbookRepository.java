package com.bit2020.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.bit2020.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {

	@Autowired
	private SqlSession sqlSession;
	public boolean delete(Long no, String password) {

		boolean result = false;

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = getConnection();

			// sql 문준비
			String sql = "delete from guestbook where no = ? and password = ?";

			pstmt = connection.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setLong(1, no);
			pstmt.setString(2, password);
			// 5. sql 실행

			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean insert(GuestbookVo vo) {

		boolean result = false;

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = getConnection();

			// sql 문준비
			String sql = "Insert into guestbook values(null,?,?,?,now())";

			pstmt = connection.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());

			// 5. sql 실행

			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<GuestbookVo> findAll() {
		// TODO Auto-generated method stub
		StopWatch sw = new StopWatch();
		sw.start();
		
		List<GuestbookVo> result = sqlSession.selectList("guestbook.findAll");

		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		
		System.out.println("[ExecutionTime]"+totalTime +"mlist");
		return result;

	}

	private Connection getConnection() throws SQLException {
		Connection connection = null;

		// 1. jdbc 라이브러리 로딩 Driver loading -> mariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3307/webdb?characterEncoding=utf8";
			// 2. db 연결하기
			connection = DriverManager.getConnection(url, "webdb", "webdb");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}

		System.out.println("연결 성공");
		return connection;
	}
}
