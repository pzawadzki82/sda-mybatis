package pl.sda.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * Created by pzawa on 02.02.2017.
 */
public class TestUtil {

    public static void cleanUpDatabase() throws IOException, SQLException {
        InputStream inputStream = TestUtil.class.getClassLoader().getResourceAsStream("sda.sql");
        String sqlContent = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            Connection conn = sqlSession.getConnection();
            conn.createStatement().executeUpdate(sqlContent);
        }
    }

}
