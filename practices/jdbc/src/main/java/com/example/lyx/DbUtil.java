package com.example.lyx;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbUtil {

	private static final String URL = "jdbc:mysql://10.43.173.180:3306/USER_INFO_DB_PERF?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String NAME = "next_user";
	private static final String PASSWORD = "next_passwd";
	Logger logger = Logger.getLogger(getClass());

	private static final DataSource dataSource =
		DataSourceBuilder.create()
				.driverClassName("com.mysql.jdbc.Driver")
				.url(URL)
				.username(NAME)
				.password(PASSWORD)
				.build();


	public Connection connect() throws SQLException {
		return dataSource.getConnection();
	}

	public User search(String sql) {
		Connection connection = null;
		User user = new User();
		try {
			logger.info("输出search()的info");
			connection = connect();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			user = jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<User>(User.class));
			System.out.println(user);
		} catch (DataAccessException e) {
			logger.error("DataAccess error");
		} catch (SQLException e) {
			System.out.println("SQLException in close():" + e);
		} finally {
			close(connection);
		}
		return user;
	}

	public List<Map<String, Object>> searchAll(String sql) {
		Connection connection = null;
		List<Map<String, Object>> user = null;
		try {
			connection = connect();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			user = jdbcTemplate.queryForList(sql);
			System.out.println(user);
		} catch (DataAccessException e) {
			
		} catch (SQLException e) {
			System.out.println("SQLException in searchAll():" + e);
		} finally {
			close(connection);
		}
		return user;
	}

	public void update(String sql, Date sdate) {
		Connection connection = null;
		try {
			connection = connect();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(sql, sdate);
		} catch (RuntimeException e) {
			logger.error("RuntimeException error", e);
		} catch (SQLException e) {
			System.out.println("SQLException in update():" + e);
		} finally {
			close(connection);
		}
	}

	public void addUser(String sql) {
		Connection connection = null;
		try {
			connection = connect();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(sql);
			System.out.println("ok");
		} catch (DataAccessException e) {
			System.out.println("DataAccessException in addUser():" + e);
		} catch (SQLException e) {
			System.out.println("SQLException in addUser():" + e);
		} finally {
			close(connection);
		}
	}

	public void delUser(String sql) {
		Connection connection = null;
		try {
			connection = connect();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(sql);
			System.out.println("ok");
		} catch (DataAccessException e) {
			System.out.println("DataAccessException in delUser():" + e);
		} catch (SQLException e) {
			System.out.println("SQLException in delUser():" + e);
		} finally {
			close(connection);
		}
	}

	public void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("SQLException in close():" + e);
			}
		}
	}
	
}
