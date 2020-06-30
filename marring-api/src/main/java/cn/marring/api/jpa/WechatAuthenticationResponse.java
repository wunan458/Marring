package cn.marring.api.jpa;

import lombok.Data;

/**
 * @author Wn 2020-06-30 14:10
 */
@Data
public class WechatAuthenticationResponse {

    private String access_token;

    public WechatAuthenticationResponse(String thirdSession) {
        this.access_token = thirdSession;
    }

}
