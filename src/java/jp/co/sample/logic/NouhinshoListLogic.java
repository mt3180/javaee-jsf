package jp.co.sample.logic;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import jp.co.sample.dao.NouhinshoMapper;
import jp.co.sample.dto.NouhinshoListItem;
import org.apache.ibatis.session.SqlSession;

/**
 * 納品書一覧処理
 */
@Dependent
public class NouhinshoListLogic {

    /**
     * SQLセッション
     */
    @Inject
    SqlSession sqlSession;

    public NouhinshoListLogic() {

    }

    /**
     * 納品書一覧データの取得
     *
     * @return 納品書一覧データ
     */
    public List<NouhinshoListItem> list() {
        NouhinshoMapper nouhinshoMapper = sqlSession.getMapper(NouhinshoMapper.class);
        return nouhinshoMapper.selectList();
    }
}
