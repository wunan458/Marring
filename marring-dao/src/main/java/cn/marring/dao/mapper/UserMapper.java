package cn.marring.dao.mapper;

import cn.marring.dao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author Wn 2020-05-19 17:02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * user list
     *
     * @return user list
     */
    List<User> queryAll(int id);
}