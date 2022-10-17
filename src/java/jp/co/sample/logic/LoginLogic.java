package jp.co.sample.logic;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import jp.co.sample.dao.LoginUserMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * ログイン処理
 */
@Dependent
public class LoginLogic {

    /**
     * SQLセッション
     */
    @Inject
    SqlSession sqlSession;

    public LoginLogic(){
        
    }
    /**
     * 認証処理
     *
     * @param userId
     * @param password
     * @return
     */
    public boolean authenticate(String userId, String password) {
        LoginUserMapper loginUserMapper = sqlSession.getMapper(LoginUserMapper.class);
         // パスワードが一致した場合、trueを返す
        return loginUserMapper.selectByUserId(userId)
                .map(lu -> lu.getPassword().equals(password))
                .orElse(Boolean.FALSE);
    }
}
