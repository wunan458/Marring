package cn.marring.api.service;

import cn.marring.api.configuration.AppContext;
import cn.marring.api.configuration.WechatAuthProperties;
import cn.marring.api.enums.Status;
import cn.marring.api.jpa.WechatAuthCodeResponse;
import cn.marring.api.jpa.WechatAuthenticationResponse;
import cn.marring.dao.entity.User;
import cn.marring.dao.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author Wn 2020-06-30 11:33
 */
@Service
public class WechatService extends BaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WechatService.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 服务器第三方session有效时间，单位秒, 默认1天
     */
    private static final Long EXPIRES = 86400L;

    private RestTemplate wxAuthRestTemplate = new RestTemplate();

    @Autowired
    private WechatAuthProperties wechatAuthProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public WechatAuthenticationResponse wechatLogin(String code) {
        WechatAuthCodeResponse response = getWxSession(code);

        String wxOpenId = response.getOpenid();
        String wxSessionKey = response.getSession_key();
        User user = new User();
        user.setOpenId(wxOpenId);
        loginOrRegisterConsumer(user);

        Long expires = response.getExpiresIn();
        String thirdSession = create3rdSession(wxOpenId, wxSessionKey, expires);
        return new WechatAuthenticationResponse(thirdSession);
    }

    public WechatAuthCodeResponse getWxSession(String code) {
        LOGGER.info(code);
        String urlString = "?appid={appid}&secret={srcret}&js_code={code}&grant_type={grantType}";
        String response = wxAuthRestTemplate.getForObject(
                wechatAuthProperties.getSessionHost() + urlString, String.class,
                wechatAuthProperties.getAppId(),
                wechatAuthProperties.getSecret(),
                code,
                wechatAuthProperties.getGrantType());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.readerFor(WechatAuthCodeResponse.class);
        WechatAuthCodeResponse res;
        try {
            res = reader.readValue(response);
        } catch (IOException e) {
            res = null;
            LOGGER.error("反序列化失败", e);
        }
        LOGGER.info(response);
        if (null == res) {
            throw new RuntimeException("调用微信接口失败");
        }
        if (res.getErrcode() != null) {
            throw new RuntimeException(res.getErrmsg());
        }
        res.setExpiresIn(res.getExpiresIn() != 0 ? res.getExpiresIn() : EXPIRES);
        return res;
    }

    public String create3rdSession(String wxOpenId, String wxSessionKey, Long expires) {
        String thirdSessionKey = RandomStringUtils.randomAlphanumeric(64);
        StringBuffer sb = new StringBuffer();
        sb.append(wxSessionKey).append("#").append(wxOpenId);

        stringRedisTemplate.opsForValue().set(thirdSessionKey, sb.toString(), expires, TimeUnit.SECONDS);
        return thirdSessionKey;
    }

    private void loginOrRegisterConsumer(User user) {
        User insertUser = getUserByOpenId(user.getOpenId());
        if (null == insertUser) {
            userMapper.insert(user);
        }
    }

    private User getUserByOpenId(String openId) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("open_id", openId);
        userQueryWrapper.eq("deleted", 0);
        return userMapper.selectOne(userQueryWrapper);
    }

    public Map<String, Object> updateConsumerInfo(User user) {
        Map<String, Object> result = new HashMap<>(5);
        updateConsumer(user);
        putMsg(result, Status.SUCCESS);
        return result;
    }

    private void updateConsumer(User user) {
        User userExist = getUserByOpenId(AppContext.getCurrentUserWechatOpenId());
        userExist.setLanguage(user.getLanguage());
        userExist.setCity(user.getCity());
        userExist.setCountry(user.getCountry());
        userExist.setLastLoginTime(new Date());
        userExist.setActiveJoinId(user.getActiveJoinId());
        userExist.setUpdatedBy(AppContext.getCurrentUserWechatOpenId());
        userExist.setCreateTime(new Date());
        userExist.setUpdateTime(new Date());
        userExist.setGender(user.getGender());
        userExist.setAvatarUrl(user.getAvatarUrl());
        userExist.setEmail(user.getEmail());
        userExist.setNickname(user.getNickname());
        userExist.setPhone(user.getPhone());
        userExist.setUserName(user.getUserName());


        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("open_id", AppContext.getCurrentUserWechatOpenId());
        userQueryWrapper.eq("deleted", 0);
        userMapper.update(userExist, userQueryWrapper);
    }

}
