package jp.co.sample.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;

/**
 * JSF互換モードではなく、JSF2.3モードにする設定
 */
@ApplicationScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class ConfigurationBean {

}
