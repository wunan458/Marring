package cn.marring.api.dto;

import cn.marring.dao.enums.Gender;
import lombok.Data;

/**
 * @author Wn 2020-06-30 11:30
 */
@Data
public class AccountDto {
    private Long id;
    private String username;
    private Long phone;
    private Gender gender;
    private String vcode;
    private String password;
    private String promotionCode;
    private String InvitationCode;
    private String clientAssertion;
    private String code;

}