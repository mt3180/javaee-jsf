/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.co.sample.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
@Singleton
@Startup
public class MyBatisSqlSessionProvidor {

    private final Map<String, SqlSessionFactory> sqlSessionFactoryCash
            = new HashMap<>();
    private String defaultId;

    /**
     * ロガー
     */
    private final static Logger logger = LogManager.getLogger(MyBatisSqlSessionProvidor.class.getName());
    /*
     * SqlSessionFactoryのインスタンスをCDI経由でインジェクションする
     */
    @PostConstruct
    public void initialize()  {
        loadDefaultEnvironment();
    }

    private void loadDefaultEnvironment() {
        try ( InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

            //デフォルトのenvironmentを読み込む
            SqlSessionFactory defaultEnvironmentFactory = builder.build(in);
            Configuration con = defaultEnvironmentFactory.getConfiguration();
            defaultId = con.getEnvironment().getId();
            sqlSessionFactoryCash.put(defaultId, defaultEnvironmentFactory);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * sqlSessionをインジェクトできるようにする
     * @return sqlSession
     */
    @Produces
    @RequestScoped
    public SqlSession openSession() {
        logger.debug("openSession()");
        return sqlSessionFactoryCash.get(defaultId).openSession();
    }

    /**
     * sqlSessionをクローズする
     * @param sqlSession 
     */
    public void closeSession(@Disposes SqlSession sqlSession) {
        logger.debug("closeSession()");
        sqlSession.close();
    }
}
