package jp.co.sample.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jp.co.sample.dto.NouhinshoListItem;
import jp.co.sample.logic.NouhinshoListLogic;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 納品書一覧画面のマネージドBean
 */
@Named(value = "nouhinshoListManagedBean")
@RequestScoped
@Getter
@Setter
public class NouhinshoListManagedBean implements Serializable {

    /**
     * FacesContext
     */
    private final FacesContext facesContext;
    /**
     * ロジッククラス
     */
    private final NouhinshoListLogic nouhinshoListLogic;
    /**
     * ロガー
     */
    private final static Logger logger = LogManager.getLogger(NouhinshoListManagedBean.class.getName());

    /**
     * コンストラクタ
     *
     * @param nouhinshoListLogic ロジッククラス
     * @param facesContext FacesContext
     */
    @Inject
    public NouhinshoListManagedBean(NouhinshoListLogic nouhinshoListLogic, FacesContext facesContext) {
        logger.info("NouhinshoListManagedBean()");
        this.nouhinshoListLogic = nouhinshoListLogic;
        this.facesContext = facesContext;
    }

    /**
     * 納品書一覧データ取得
     *
     * @return 納品書一覧データ
     */
    public List<NouhinshoListItem> list() {
        logger.info("list()");
        return nouhinshoListLogic.list();
    }

    /**
     * 納品書ダウンロード
     *
     * @param nouhinId 納品ID
     */
    public void download(String nouhinId) {
        logger.info("download() nouhinId={}", nouhinId);

        String fileName = "sample.csv";
        
        ExternalContext ec = facesContext.getExternalContext();
        ec.responseReset();
        ec.setResponseContentType("text/html; charset=Windows-31J");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try(PrintWriter w = new PrintWriter(ec.getResponseOutputStream());) {
            String csvStr = "\"id\",\"name\"\n\"1\",\"sample\"";
            w.print(csvStr);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }

        FacesContext.getCurrentInstance().responseComplete();
    }
}
