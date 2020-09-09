package com.example.lyx;

import static org.mockito.ArgumentMatchers.any;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(PowerMockRunner.class)// 告诉JUnit使用PowerMockRunner进行测试
@PrepareForTest({DbUtil.class, Logger.class})// 所有需要测试的类列在此处，
											//	适用于模拟final类或有final, private, static, native方法的类
public class DbUtilTest {
	Logger logger = Logger.getLogger(getClass());
	@Mock
	JdbcTemplate jdbcTemplate;
	@Test
	public void testUpdate() throws Exception {
		DbUtil dbUtil = new DbUtil();//PowerMockito.mock(DbUtil.class);
		java.util.Date udate=new java.util.Date();
		java.sql.Date sdate=new java.sql.Date(udate.getTime());
		String sql = "UPDATE USER_INFO_DB_PERF.USER_INFO_TBL SET UPDATE_TIME=? WHERE LOGIN_ID='00000000002008'";
		
		Connection connection = PowerMockito.mock(Connection.class);
		DataSource dataSource = PowerMockito.mock(DataSource.class);
		PowerMockito.when(dataSource.getConnection()).thenReturn(connection);// mock普通方法
//		JdbcTemplate jdbcTemplate = PowerMockito.mock(JdbcTemplate.class);
		PowerMockito.whenNew(JdbcTemplate.class).withArguments(any()).thenReturn(jdbcTemplate);
		PowerMockito.doThrow(new RuntimeException("this is runtimeException")).when(jdbcTemplate).update(sql, sdate);
//		Statement statement = PowerMockito.mock(Statement.class);
//		PowerMockito.when(connection.createStatement()).thenReturn(statement);
		PowerMockito.doNothing().when(connection).close();// mock 返回值为 void 的方法
		dbUtil.update(sql, sdate);
		Mockito.verify(jdbcTemplate).update(sql, sdate);
		logger.error("this is error");
	}
}
