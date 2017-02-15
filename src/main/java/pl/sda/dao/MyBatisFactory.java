package pl.sda.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by pzawa on 02.02.2017.
 */
public class MyBatisFactory {

    public static SqlSessionFactory getSqlSessionFactory() throws SQLException {
        InputStream inputStream = MyBatisFactory.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        Properties properties = new Properties();
        //FIXME - load from external properties file
        properties.setProperty("schema", "sda");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);

        return sqlSessionFactory;
    }

}
