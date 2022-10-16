package jp.co.sample.dto;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

/**
 *
 * 納品書DTO
 */
@Data
public class NouhinshoListItem implements Serializable {

    /**
     * 納品ID
     */
    private String nouhinId;
    /**
     * 件名
     */
    private String title;
    /**
     * 会社名
     */
    private String kaishaName;
    /**
     * 納品日
     */
    private Date nouhinDate;
    /**
     * 納品会社名
     */
    private String nouhinKaishaName;
    /**
     * 納品金額
     */
    private int nouhinKingaku;
    
}
