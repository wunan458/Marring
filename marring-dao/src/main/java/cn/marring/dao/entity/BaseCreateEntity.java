package cn.marring.dao.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wn 2020-06-12 11:23
 */
@Data
class BaseCreateEntity implements Serializable {
    /**
     * create time
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * update time
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * created by
     */
    private Integer createdBy;
    /**
     * updated by
     */
    private Integer updatedBy;
}
