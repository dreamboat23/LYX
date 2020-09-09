package com.example.lyx;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

	@Autowired
	private DbUtil dbUtil;
	


	@GetMapping("/userfindall")
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>> user = null;
		String sql = "SELECT * FROM USER_INFO_DB_PERF.USER_INFO_TBL WHERE LOGIN_ID='00000000002008'";
//		String sql = "SELECT * FROM USER_INFO_DB_PERF.USER_INFO_TBL WHERE NODE_ID='888'";
		user = dbUtil.searchAll(sql);
		return user;

	}

	@GetMapping("/userfindbyid")
	public User findById() {
		User user = new User();
		String sql = "SELECT * FROM USER_INFO_DB_PERF.USER_INFO_TBL WHERE LOGIN_ID='00000000002008'";
		user = dbUtil.search(sql);
		Logger logger = Logger.getLogger(getClass());
		logger.info("输出info了");
//		if(logger.isDebugEnabled()){
			logger.debug("bug！");
//		}
		logger.error("输出error了");
		return user;

	}
	@GetMapping("/userupdate")
	public List<User> updateUser() {
		java.util.Date udate=new java.util.Date();
		java.sql.Date sdate=new java.sql.Date(udate.getTime());
		List<User> user = null;
		String sql = "UPDATE USER_INFO_DB_PERF.USER_INFO_TBL SET UPDATE_TIME=? WHERE LOGIN_ID='00000000002008'";
		dbUtil.update(sql, sdate);
		return user;

	}
	
	@GetMapping("/useradd")
	public List<User> add() {
		List<User> user = null;
		String sql = "INSERT INTO `USER_INFO_DB_PERF`.`USER_INFO_TBL` (`LOGIN_ID`, `NODE_ID`) VALUES ('00000000019', '888');";
		dbUtil.addUser(sql);
		return user;

	}
	@GetMapping("/userdel")
	public List<User> del() {
		List<User> user = null;
		String sql = "DELETE FROM USER_INFO_DB_PERF.USER_INFO_TBL WHERE LOGIN_ID='00000000019'";
		dbUtil.delUser(sql);
		return user;

	}

}
