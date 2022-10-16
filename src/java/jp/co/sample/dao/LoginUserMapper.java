package jp.co.sample.dao;

import java.util.Optional;
import jp.co.sample.dto.LoginUser;

/**
 *
 * ログインユーザのMybatis Mapperインタフェース
 */
public interface LoginUserMapper {
    
    Optional<LoginUser> selectByUserId(String userId);
}
