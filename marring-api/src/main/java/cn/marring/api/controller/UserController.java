package cn.marring.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author Wn 2020-05-19 16:14
 */
@Api(tags = "USER")
@ApiSort(value = 1)
@RestController
@RequestMapping("/user")
public class UserController {
}
