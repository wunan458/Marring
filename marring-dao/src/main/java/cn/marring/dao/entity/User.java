package cn.marring.dao.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.marring.common.Constants.PARAMETER_FORMAT_TIME_ON;

/**
 * @author Wn 2020-06-12 11:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_matrix_user")
public class User extends BaseCreateEntity {
    /**
     * user id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    /**
     * employee number
     */
    private int employeeNumber;
    /**
     * user name
     */
    private String userName;
    /**
     * user password
     */
    private String userPassword;
    /**
     * state
     */
    private int state;
    /**
     * description
     */
    private String description;
    /**
     * phone
     */
    private String phone;
    /**
     * email
     */
    private String email;
    /**
     * expire time
     */
    @DateTimeFormat(pattern = PARAMETER_FORMAT_TIME_ON)
    @JSONField(format = PARAMETER_FORMAT_TIME_ON)
    private Date expireTime;
    /**
     * user type 0:admin
     */
    private int userType;
    /**
     * resource space id
     */
    @TableField(exist = false)
    private int resourceSpaceId;
    /**
     * resource space name
     */
    @TableField(exist = false)
    private String resourceSpaceName;
    /**
     * resource space alias
     */
    @TableField(exist = false)
    private String resourceSpaceAlias;

}


