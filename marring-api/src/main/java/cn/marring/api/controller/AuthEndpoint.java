package cn.marring.api.controller;

import cn.marring.api.dto.AccountDto;
import cn.marring.api.enums.Status;
import cn.marring.api.jpa.WechatAuthenticationResponse;
import cn.marring.api.service.WechatService;
import cn.marring.api.utils.Result;
import cn.marring.dao.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Wn 2020-06-30 11:32
 */
@RestController
public class AuthEndpoint extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AuthEndpoint.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private WechatService wechatService;

    @GetMapping("/test")
    public String test() {
        return "test_success";
    }

    @GetMapping("/testAuth")
    public String testAuth() {
        return "testAuth_success";
    }

    @PostMapping("/auth")
    public ResponseEntity<WechatAuthenticationResponse> createAuthenticationToken(@RequestBody AccountDto accountDto)
            throws AuthenticationException {
        WechatAuthenticationResponse jwtResponse = wechatService.wechatLogin(accountDto.getCode());
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/updateConsumerInfo")
    public Result updateConsumerInfo(@RequestBody User user) {
        try {
            Map<String, Object> result = wechatService.updateConsumerInfo(user);
            return returnDataList(result);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return error(Status.UPDATE_USER_ERROR.getCode(), Status.UPDATE_USER_ERROR.getMsg());
        }

    }

}
