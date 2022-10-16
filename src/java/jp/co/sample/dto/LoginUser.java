package jp.co.sample.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * ログインユーザDTO
 */
@Data
public class LoginUser implements Serializable {

    /**
     * ユーザID
     */
    private String userId;
    /**
     * ユーザ名
     */
    private String userName;
    /**
     * ロールID
     */
    private String roleId;
    /**
     * パスワード
     */
    private String password;

}
