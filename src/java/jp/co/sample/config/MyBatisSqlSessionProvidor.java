package jp.co.sample.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import jp.co.sample.service.NouhinshoListManagedBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
@Stateless
public class MyBatisSqlSessionProvidor {

    @Inject
    private SqlSessionFactory sampleSessionFactory;
    /**
     * ロガー
     */
    private final static Logger logger = LogManager.getLogger(MyBatisSqlSessionProvidor.class.getName());

    /**
     * sampleデータソースのSqlSessionFactoryのインスタンスをCDIに登録
     *
     * @return SqlSessionFactory
     */
    @ApplicationScoped
    @Produces
    public SqlSessionFactory sampleSessionFactory() {
        return this.create("sample");
    }

    /**
     * SqlSessionFactoryを作成
     *
     *
     * @param environment environment
     * @return SqlSessionFactory
     */
    private SqlSessionFactory create(String environment) {
        try ( InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            return builder.build(stream, environment);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /*
     * `SqlSession`をインジェクションするためのメソッド
     * Request毎にopen/closeするため`@RequestScoped`を指定
     * `@Produces`でCDI経由でインスタンスを取得できるようになる
     */
    @RequestScoped
    @Produces
    public SqlSession openSampleSession() {
        logger.info("openSampleSession()");
        return sampleSessionFactory.openSession();
    }
    
    /**
     * Requestが完了したときに`SqlSession`をcloseする
     * @param sqlSession 
     */
    public void closeSampleSession(@Disposes SqlSession sqlSession) {
        logger.info("closeSampleSession()");
        sqlSession.close();
    }
}
