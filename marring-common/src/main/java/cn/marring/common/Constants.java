package cn.marring.common;


import java.util.regex.Pattern;

/**
 * Constants
 *
 * @author Wn 2020-06-10 17:02
 */
public class Constants {
    private Constants() {
        throw new IllegalStateException("Constants class");
    }

    /**
     * message
     */
    public static final String MSG = "msg";

    public static final String DATA_LIST = "data";

    public static final String TOTAL_LIST = "totalList";

    public static final String CURRENT_PAGE = "currentPage";

    public static final String TOTAL_PAGE = "totalPage";

    public static final String TOTAL = "total";

    /**
     * status
     */
    public static final String STATUS = "status";

    public static final String MODEL_CONF = "model.properties";

    public static final String DATA_PORTRAIT_INTERVAL = "data.portrait.interval";

    public static final String MONITOR_DATE_CENTER_INTERVAL = "monitor.date.center.interval";

    public static final String DOT = ".";

    public static final String COMMA = ",";

    public static final String LIBSVM = "libsvm";

    public static final String KEY = "key";


    /**
     * model properties
     */
    public static final String MODEL_FILE_STORE_LIBSVM_PATH = "model.file.store.libsvm.path";

    /**
     * data total
     * 数据总数
     */
    public static final String COUNT = "count";

    /**
     * page size
     * 每页数据条数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * current page no
     * 当前页码
     */
    public static final String PAGE_NUMBER = "pageNo";

    /**
     * system date(yyyyMMddHHmmss)
     */
    public static final String PARAMETER_DATETIME = "system.datetime";

    /**
     * date format of yyyyMMddHHmmss
     */
    public static final String PARAMETER_FORMAT_TIME = "yyyyMMddHHmmss";

    public static final String PARAMETER_FORMAT_TIME_ON = "yyyy-MM-dd";

    public static final String SLASH = "/";

    public static final String PMML = ".pmml";

    /**
     * table column
     */
    public static final String RESOURCE_SPACE_NAME = "resource_space_name";

    public static final String GROUP_SPACE_NAME = "group_space_name";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String RESOURCE_SPACE_ID = "resource_space_id";

    public static final String GROUP_SPACE_ID = "group_space_id";

    public static final String OWNER = "owner";

    public static final String ID = "id";



    /**
     * user name regex
     */
    public static final Pattern REGEX_USER_NAME = Pattern.compile("^[a-zA-Z0-9._-]{3,20}$");

    /**
     * email regex
     */
    public static final Pattern REGEX_MAIL_NAME = Pattern.compile("^([a-z0-9A-Z]+[_|\\-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");



}
