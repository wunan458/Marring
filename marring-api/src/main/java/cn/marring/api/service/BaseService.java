package cn.marring.api.service;

import cn.marring.api.enums.Status;
import cn.marring.api.utils.Result;
import cn.marring.common.Constants;
import cn.marring.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.Map;


/**
 * BaseService
 *
 * @author Wn 2020-05-19 17:26
 */
public class BaseService {

    @Autowired
    UserMapper userMapper;

    /**
     * put message to map
     *
     * @param result       result code
     * @param status       status
     * @param statusParams status message
     */
    protected void putMsg(Map<String, Object> result, Status status, Object... statusParams) {
        result.put(Constants.STATUS, status);
        if (statusParams != null && statusParams.length > 0) {
            result.put(Constants.MSG, MessageFormat.format(status.getMsg(), statusParams));
        } else {
            result.put(Constants.MSG, status.getMsg());
        }
    }

    /**
     * put message to result object
     *
     * @param result       result code
     * @param status       status
     * @param statusParams status message
     */
    protected void putMsg(Result result, Status status, Object... statusParams) {
        result.setCode(status.getCode());

        if (statusParams != null && statusParams.length > 0) {
            result.setMsg(MessageFormat.format(status.getMsg(), statusParams));
        } else {
            result.setMsg(status.getMsg());
        }

    }

}
