package cn.marring.api.message;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @author Wn 2020-07-03 17:32
 */
@Component
@Data
public class MessageSend {

    @Value("${cloud.tencent.message.appId}")
    private int appId=1400395031;

    @Value("${cloud.tencent.message.appKey}")
    private String appKey="a1efeb68ec7e556df59a6e8e555edc66";

    @Value("${cloud.tencent.message.templateId}")
    private int templateId;

    @Value("${cloud.tencent.message.nationCode}")
    private String nationCode="86";

    /**
     * 腾讯云短信,100条一个月
     * 方法说明
     *
     * @param phone
     * @return void
     * @Discription:扩展说明
     */
    public void sendMsgByTxPlatform(String phone) throws Exception {

        // 签名
        // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
        String smsSign = "我的小碗汤";

        SmsSingleSender sSender = new SmsSingleSender(appId, appKey);
        //第一个参数0表示普通短信,1表示营销短信
        SmsSingleSenderResult result = sSender.send(0, nationCode,
                phone,
                getSixValidationCode() + "为您的登录验证码，请于" + 10 + "分钟内填写。如非本人操作，请忽略本短信。", "", "");

        if (result.result != 0) {
            throw new Exception("send phone validateCode is error" + result.errMsg);
        }
    }

    private static String getSixValidationCode() {
        String sjs = "";

        for (int i = 0; i < 6; i++) {
            int max = 9, min = 0;
            int ran2 = (int) (Math.random() * (max - min) + min);
            sjs = ran2 + sjs;
        }
        System.out.println("6位随机数： " + sjs);
        return sjs;
    }

    @Test
    public void test() throws Exception {
        sendMsgByTxPlatform("17610979992");
    }
}
