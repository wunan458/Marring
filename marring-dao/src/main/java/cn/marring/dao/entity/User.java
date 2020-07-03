package cn.marring.dao.entity;

import cn.marring.dao.enums.Gender;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Wn 2020-06-30 11:31
 */
@Data
@TableName("t_marring_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String userName;
    /**
     * 微信唯一主键
     */
    private String openId;
    /**
     * 微信匿名
     */
    private String nickname;
    /**
     * 微信头像地址
     */
    private String avatarUrl;
    /**
     * 性别
     */
    private Gender gender;

    private String language;

    private String phone;

    private String email;

    private String city;

    private String country;

    private Date lastLoginTime;
    /**
     * 用户当前的参加的active的婚礼
     */
    private int activeJoinId;
    /**
     * 0: active 1: deleted
     */
    private int deleted;
    /**
     * create by user id
     */
    private String createdBy;
    /**
     * update by user id
     */
    private String updatedBy;

    private Date createTime;

    private Date updateTime;
}
