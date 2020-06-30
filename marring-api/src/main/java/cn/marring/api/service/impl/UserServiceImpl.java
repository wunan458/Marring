package cn.marring.api.service.impl;

import cn.marring.api.enums.Status;
import cn.marring.api.service.BaseService;
import cn.marring.api.service.UserService;
import cn.marring.common.Constants;
import cn.marring.dao.entity.User;
import cn.marring.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wn 2020-06-12 14:35
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public Map<String, Object> queryAll() {
        Map<String, Object> result = new HashMap<>(5);
         /*
        check login user
         */
        List<User> users = userMapper.queryAll(9);
        result.put(Constants.DATA_LIST, users);
        putMsg(result, Status.SUCCESS);
        return result;
    }


}
