package jp.co.sample.service;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import jp.co.sample.common.util.MessageUtil;
import jp.co.sample.logic.LoginLogic;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ログイン画面のマネージドBean
 */
@Named(value = "loginManagedBean")
@RequestScoped
@Getter
@Setter
public class LoginManagedBean implements Serializable {

    /**
     * ユーザID
     */
    @NotEmpty
    private String userId;
    /**
     * パスワード
     */
    @NotEmpty
    private String password;
    /**
     * FacesContext
     */
    private final FacesContext facesContext;
    /**
     * ロジッククラス
     */
    private final LoginLogic loginLogic;
    /**
     * ロガー
     */
    private final static Logger logger = LogManager.getLogger(LoginManagedBean.class.getName());

    /**
     * コンストラクタ
     *
     * @param loginLogic
     * @param facesContext FacesContext
     */
    @Inject
    public LoginManagedBean(LoginLogic loginLogic, FacesContext facesContext) {
        logger.info("LoginManagedBean()");
        this.loginLogic = loginLogic;
        this.facesContext = facesContext;
    }

    public String login() {
        logger.info("login()");
        if (loginLogic.authenticate(userId, password)) {
            return "/home?faces-redirect=true";
        } else {
            MessageUtil.addFacesErrorMsg("ログインに失敗しました。", facesContext);
            return "login";
        }
    }

}
