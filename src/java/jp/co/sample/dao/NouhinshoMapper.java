package jp.co.sample.dao;

import java.util.List;
import jp.co.sample.dto.NouhinshoListItem;

/**
 *
 * 納品書のMybatis Mapperインタフェース
 */
public interface NouhinshoMapper {
    
    List<NouhinshoListItem> selectList(String searchWord);
}
