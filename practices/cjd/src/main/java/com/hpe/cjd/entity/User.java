package com.hpe.cjd.entity;


import lombok.Data;
import java.util.Date;


@Data
public class User {

    private String loginId;
    private int nodeId;
    private String authPw;
    private Date updateTime;
    private String mdn;
    private String mailAddr;
    private int serviceId;
    private int webMailUseFlg;
}
