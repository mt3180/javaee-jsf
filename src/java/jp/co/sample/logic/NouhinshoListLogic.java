package jp.co.sample.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import jp.co.sample.dao.NouhinshoMapper;
import jp.co.sample.dto.NouhinshoListItem;
import org.apache.ibatis.session.SqlSession;

/**
 * 納品書一覧処理
 */
@Stateless
public class NouhinshoListLogic {

    /**
     * SQLセッション
     */
    @Inject
    SqlSession sqlSession;


    /**
     * 納品書一覧データの取得
     *
     * @param searchWord 検索ワード
     * @return 納品書一覧データ
     */
    public List<NouhinshoListItem> list(String searchWord) {
        NouhinshoMapper nouhinshoMapper = sqlSession.getMapper(NouhinshoMapper.class);
        return nouhinshoMapper.selectList(searchWord);
    }
}
