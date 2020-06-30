package cn.marring.api.controller;

import cn.marring.api.enums.Status;
import cn.marring.api.service.UserService;
import cn.marring.api.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Wn 2020-06-12 14:19
 */
@Api(tags = "USER")
@ApiSort(value = 4)
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "queryAll", notes = "QUERY_ALL")
    @ApiImplicitParams({
    })
    @GetMapping(value = "/query_all")
    @ResponseStatus(HttpStatus.OK)
    public Result queryAll() {
        try {
            Map<String, Object> result = userService.queryAll();
            return returnDataList(result);
        } catch (Exception e) {
            return error(Status.QUERY_USER_ALL_ERROR.getCode(), Status.QUERY_USER_ALL_ERROR.getMsg());
        }
    }

}
