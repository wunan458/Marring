package cn.marring.api.enums;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * Status
 *
 * @author Wn 2020-05-19 16:56
 */
public enum Status {
    SUCCESS(0, "success", "成功"),
    QUERY_DATA_FIGURE_ERROR(10000, "query data figure error", "查询数据画像错误"),
    REQUEST_PARAMS_NOT_VALID_ERROR(10001, "request parameter {0} is not valid", "请求参数[{0}]无效"),
    QUERY_DATA_PROFILE_LIST_ERROR(10002, "query data profile list error", "查询数据画像列表错误"),
    FILE_NOT_FOUND_ERROR(10003, "file not found error : {0}", "文件不存在：{0}"),
    JSON_PARASE_EXCEPTION(10004, "json parse exception : {0}", "json parse exception : {0}"),
    PAGE_LIST_IS_NULL(10005, "page list is null ,msg : ", "page list is null ,msg : "),
    QUERY_MODEL_DEF_ERROR(10006, "query model def error ", "查询推荐模型错误"),
    MODEL_TRAIN_ERROR(10007, "model train error ", "模型训练错误"),
    QUERY_MODEL_TRAIN_LOG_ERROR(10008, "query model train log error ", "查询模型训练日志错误"),
    QUERY_APPLICATION_KEEPER_LIST_ERROR(10009, "query application keeper list error ", "查询模型训练任务错误"),
    CREATE_USER_ERROR(10010, "create user error ", "用户创建错误"),
    CREATE_RESOURCE_SPACE_ERROR(10011, "create resource space error ", "资源池创建错误"),
    RESOURCE_SPACE_EXISTS_ERROR(10012, "resource space exists error ", "资源池名称已存在"),
    UPDATE_RESOURCE_SPACE_ERROR(10013, "update resource space error ", "资源池编辑错误"),
    DELETE_RESOURCE_SPACE_ERROR(10014, "delete resource space error ", "资源池删除错误"),
    RESOURCE_NOT_EXISTS_SPACE_ERROR(20014, "resource space not exists error ", "该资源池不存在错误"),
    QUERY_RESOURCE_SPACE_LIST_PAGING_ERROR(10015, "query resource space list paging error", "资源池分页查询错误"),
    QUERY_USER_LIST_PAGING_ERROR(20015, "query user list paging error", "用户分页查询错误"),
    QUERY_RESOURCE_SPACE_BY_ID_ERROR(10016, "query resource space by id error", "资源池信息查询错误"),
    QUERY_GROUP_SPACE_BY_NAME_ERROR(20016, "query group space by name error", "组空间信息查询错误"),
    QUERY_USER_BY_ID_ERROR(20016, "query user by id error", "用户信息查询错误"),
    QUERY_RESOURCE_SPACE_ALL_ERROR(10017, "query all resource space by id error", "资源池信息查询错误"),
    QUERY_USER_ALL_ERROR(20017, "query all user error", "用户查询错误"),
    USER_NAME_EXISTS_ERROR(10018, "user name exists error ", "用户名已存在"),
    GROUP_SPACE_NAME_EXISTS_ERROR(10019, "group space name exists error ", "组空间名称已存在"),
    UPDATE_USER_ERROR(10020, "update user error ", "用户编辑错误"),
    USER_NOT_EXISTS_ERROR(10021, "user not exists error ", "该用户不存在"),
    CREATE_GROUP_SPACE_ERROR(10022, "create group space error ", "组空间创建错误"),
    UPDATE_GROUP_SPACE_ERROR(10023, "update group space error ", "组空间编辑错误"),
    GROUP_SPACE_NOT_EXISTS_ERROR(10024, "group space not exists error", "该组空间不存在"),
    QUERY_LOGIN_USER_ERROR(10029, "query login user error", "登录用户不存在"),
    USER_NO_OPERATION_PERM(10030, "user has no operation privilege", "当前用户没有操作权限"),
    USER_OFF_ERROR(10031, "login user off", "当前登录用户禁用"),
    USER_EXPIRE_TIME_ERROR(10032, "login user expire time", "当前登录用户已过有效期"),
    QUERY_MENU_ERROR(10035, "query menu error", "菜单查询错误"),
    QUERY_USER_BY_NAME_ERROR(10036, "query user by name error", "用户信息查新错误"),
    LOGIN_USER_HAS_NO_PERMIT_ERROR(10037, "login user has no permit", "该登录用户无权限"),








    ;
    private final int code;
    private final String enMsg;
    private final String zhMsg;

    private Status(int code, String enMsg, String zhMsg) {
        this.code = code;
        this.enMsg = enMsg;
        this.zhMsg = zhMsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        if (Locale.SIMPLIFIED_CHINESE.getLanguage().equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.zhMsg;
        } else {
            return this.enMsg;
        }
    }


}
