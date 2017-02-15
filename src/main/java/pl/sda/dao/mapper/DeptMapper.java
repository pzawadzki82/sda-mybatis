package pl.sda.dao.mapper;

import org.apache.ibatis.annotations.*;
import pl.sda.domain.Department;

/**
 * Created by pzawa on 15.02.2017.
 */
public interface DeptMapper {
    @Results({
            @Result(property = "deptno", column = "deptno"),
            @Result(property = "dname", column = "dname"),
            @Result(property = "location", column = "location")
    })
    @Select("SELECT deptno, dname, location FROM ${schema}.Dept WHERE deptno = #{deptno}")
    Department selectDepartment(int id);

    @Insert("INSERT into ${schema}.Dept(deptno, dname, location) VALUES(#{deptno}, #{dname}, #{location})")
    void insertDepartment(Department department);

    @Update("UPDATE ${schema}.Dept SET dname = #{dname}, location = #{location} WHERE deptno = #{deptno}")
    void updateDepartment(Department department);

    @Delete("DELETE FROM ${schema}.Dept WHERE deptno = #{deptno}")
    void deleteDepartment(int deptno);
}
