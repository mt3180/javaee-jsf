package jp.co.sample.common.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * メッセージに関するユーティリティクラス
 */
public final class MessageUtil {

    private MessageUtil() {
    }

    /**
     * FacesContextにエラーメッセージを追加します。
     * @param msg エラーメッセージ
     * @param facesContext FacesContext
     */
    public static void addFacesErrorMsg(String msg, FacesContext facesContext) {
        FacesMessage errmsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        facesContext.addMessage(null, errmsg);
    }
}
