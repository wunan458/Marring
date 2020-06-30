package cn.marring.api.jpa;

import lombok.Data;

/**
 * @author Wn 2020-06-30 14:02
 */
@Data
public class WechatAuthCodeResponse {
    private String session_key;
    private String openid;
    private String errcode;
    private String errmsg;
    private long expiresIn = 86400L;
}
