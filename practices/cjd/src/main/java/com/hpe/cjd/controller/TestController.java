package com.hpe.cjd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.cjd.entity.User;



@RestController
@RequestMapping("/index")
public class TestController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/list")
    public List<Map<String, Object>> itemsList() {
        String sql = "SELECT * FROM USER_INFO_DB_PERF.USER_INFO_TBL";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.size());
        return list;
    }
    @RequestMapping("/userbyid")
    public User findbyid() {
        String sql = "SELECT * FROM USER_INFO_DB_PERF.USER_INFO_TBL WHERE LOGIN_ID='00000000002008'";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(user);
        return user;
    }
}
