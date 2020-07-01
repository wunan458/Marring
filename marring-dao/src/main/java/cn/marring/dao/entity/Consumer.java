package cn.marring.dao.entity;

import cn.marring.dao.enums.Gender;
import lombok.Data;

/**
 * @author Wn 2020-06-30 11:31
 */
@Data
public class Consumer {
    private Long id;
    private String username;
    private String openId;
    private String phone;
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
    private String email;
    private Long lastLoginTime;
    private Boolean deleted;
    private Long createdBy;
    private Long createdAt;
    private Long updatedBy;
    private Long updatedAt;
    private String language;
    private String city;
    private String country;
}
