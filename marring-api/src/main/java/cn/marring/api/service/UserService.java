package cn.marring.api.service;

import java.util.Map;

/**
 * @author Wn 2020-06-12 14:34
 */
public interface UserService {

    /**
     * query all users
     *
     * @return result map
     */
    Map<String, Object> queryAll();
}
