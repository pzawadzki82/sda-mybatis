package pl.sda.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.sda.dao.mapper.DeptMapper;
import pl.sda.domain.Department;
import java.sql.SQLException;

/**
 * Created by pzawa on 02.02.2017.
 */
public class DeptDAOMyBatisImpl implements DeptDAO{
    private static String QUERY_BY_ID  = "SELECT deptno, dname, location FROM Dept WHERE deptno = ?";
    private static String INSERT_STMT = "INSERT INTO Dept(deptno, dname, location) VALUES(?,?,?)";
    private static String UPDATE_STMT= "UPDATE Dept set dname = ?, location = ?  WHERE deptno = ?";
    private static String DELETE_STMT= "DELETE FROM Dept WHERE deptno = ?";

    @Override
    public Department findById(int id) throws SQLException {
        SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
        try(SqlSession session = sqlSessionFactory.openSession()) {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            Department department = mapper.selectDepartment(id);
            return department;
        }
    }

    @Override
    public void create(Department department) throws SQLException {
        SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
        try(SqlSession session = sqlSessionFactory.openSession()) {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            mapper.insertDepartment(department);
            session.commit();
        }
    }

    @Override
    public void update(Department department) throws SQLException {
        SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
        try(SqlSession session = sqlSessionFactory.openSession()) {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            mapper.updateDepartment(department);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        SqlSessionFactory sqlSessionFactory = MyBatisFactory.getSqlSessionFactory();
        try(SqlSession session = sqlSessionFactory.openSession()) {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            mapper.deleteDepartment(id);
            session.commit();
        }
    }
}
