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
    private String wechatOpenid;
    private Long phone;
    private String nickname;
    private String avatarUrl;
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
