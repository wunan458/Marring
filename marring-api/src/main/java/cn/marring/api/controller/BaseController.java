package cn.marring.api.controller;

import cn.marring.api.enums.Status;
import cn.marring.api.utils.PageInfo;
import cn.marring.api.utils.Result;
import cn.marring.common.Constants;
import cn.marring.dao.entity.User;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseController
 *
 * @author Wn 2020-05-19 16:53
 */
public class BaseController {


    /**
     * check params
     *
     * @param pageNo   page number
     * @param pageSize page size
     * @return check result code
     */
    public Map<String, Object> checkPageParams(int pageNo, int pageSize) {
        Map<String, Object> result = new HashMap<>(2);
        Status resultEnum = Status.SUCCESS;
        String msg = Status.SUCCESS.getMsg();
        if (pageNo <= 0) {
            resultEnum = Status.REQUEST_PARAMS_NOT_VALID_ERROR;
            msg = MessageFormat.format(Status.REQUEST_PARAMS_NOT_VALID_ERROR.getMsg(), Constants.PAGE_NUMBER);
        } else if (pageSize <= 0) {
            resultEnum = Status.REQUEST_PARAMS_NOT_VALID_ERROR;
            msg = MessageFormat.format(Status.REQUEST_PARAMS_NOT_VALID_ERROR.getMsg(), Constants.PAGE_SIZE);
        }
        result.put(Constants.STATUS, resultEnum);
        result.put(Constants.MSG, msg);
        return result;
    }

    /**
     * return data list
     *
     * @param result result code
     * @return result code
     */
    public Result returnDataList(Map<String, Object> result) {
        Status status = (Status) result.get(Constants.STATUS);
        if (status == Status.SUCCESS) {
            String msg = Status.SUCCESS.getMsg();
            Object datalist = result.get(Constants.DATA_LIST);
            return success(msg, datalist);
        } else {
            Integer code = status.getCode();
            String msg = (String) result.get(Constants.MSG);
            return error(code, msg);
        }
    }

    /**
     * return data list with paging
     *
     * @param result result code
     * @return result code
     */
    public Result returnDataListPaging(Map<String, Object> result) {
        Status status = (Status) result.get(Constants.STATUS);
        if (status == Status.SUCCESS) {
            result.put(Constants.MSG, Status.SUCCESS.getMsg());
            PageInfo<User> pageInfo = (PageInfo<User>) result.get(Constants.DATA_LIST);
            return success(pageInfo.getLists(), pageInfo.getCurrentPage(), pageInfo.getTotalCount(),
                    pageInfo.getTotalPage());
        } else {
            Integer code = status.getCode();
            String msg = (String) result.get(Constants.MSG);
            return error(code, msg);
        }
    }

    /**
     * success
     *
     * @return success result code
     */
    public Result success() {
        Result result = new Result();
        result.setCode(Status.SUCCESS.getCode());
        result.setMsg(Status.SUCCESS.getMsg());

        return result;
    }

    /**
     * success does not need to return data
     *
     * @param msg success message
     * @return success result code
     */
    public Result success(String msg) {
        Result result = new Result();
        result.setCode(Status.SUCCESS.getCode());
        result.setMsg(msg);

        return result;
    }

    /**
     * return data no paging
     *
     * @param msg  success message
     * @param list data list
     * @return success result code
     */
    public Result success(String msg, Object list) {
        return getResult(msg, list);
    }

    /**
     * return data no paging
     *
     * @param list success
     * @return success result code
     */
    public Result success(Object list) {
        return getResult(Status.SUCCESS.getMsg(), list);
    }

    /**
     * return the data use Map format, for example, passing the value of key, value, passing a value
     * eg. "/user/add"  then return user name: zhangsan
     *
     * @param msg    message
     * @param object success object data
     * @return success result code
     */
    public Result success(String msg, Map<String, Object> object) {
        return getResult(msg, object);
    }

    /**
     * return data with paging
     *
     * @param totalList   success object list
     * @param currentPage current page
     * @param total       total
     * @param totalPage   total page
     * @return success result code
     */
    public Result success(List totalList, Integer currentPage,
                          Integer total, Integer totalPage) {
        Result result = new Result();
        result.setCode(Status.SUCCESS.getCode());
        result.setMsg(Status.SUCCESS.getMsg());

        Map<String, Object> map = new HashMap<>(4);
        map.put(Constants.TOTAL_LIST, totalList);
        map.put(Constants.CURRENT_PAGE, currentPage);
        map.put(Constants.TOTAL_PAGE, totalPage);
        map.put(Constants.TOTAL, total);
        result.setData(map);
        return result;
    }

    /**
     * error handle
     *
     * @param code result code
     * @param msg  result message
     * @return error result code
     */
    public Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    /**
     * put message to map
     *
     * @param result       result
     * @param status       status
     * @param statusParams object messages
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
     * @param result       result
     * @param status       status
     * @param statusParams status parameters
     */
    protected void putMsg(Result result, Status status, Object... statusParams) {
        result.setCode(status.getCode());

        if (statusParams != null && statusParams.length > 0) {
            result.setMsg(MessageFormat.format(status.getMsg(), statusParams));
        } else {
            result.setMsg(status.getMsg());
        }

    }

    /**
     * get result
     *
     * @param msg  message
     * @param list object list
     * @return result code
     */
    private Result getResult(String msg, Object list) {
        Result result = new Result();
        result.setCode(Status.SUCCESS.getCode());
        result.setMsg(msg);

        result.setData(list);
        return result;
    }

}
