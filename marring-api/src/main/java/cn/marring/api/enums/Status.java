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
    UPDATE_USER_ERROR(10000, "update user error", "用户更新错误"),
    REQUEST_PARAMS_NOT_VALID_ERROR(10001, "request parameter {0} is not valid", "请求参数[{0}]无效"),
    QUERY_USER_ALL_ERROR(20017, "query all user error", "用户查询错误"),








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
