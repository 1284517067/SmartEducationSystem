package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Teacher;

import java.util.List;

@Repository
@Mapper
public interface TeacherDao {
    @Select("select * from teacher")
    List<Teacher> getTeacherList();
    @Select("select * from teacher where id = #{id}")
    Teacher getTeacherById(long id);
    @Insert("insert into teacher(id,name,school,department,password,major,tel) values(#{id},#{name},#{school},#{department},#{password},#{major},#{tel})")
    int addTeacher(Teacher teacher);
    @Update("update teacher set name = #{name},school = #{school},department = #{department},password = #{password},major = #{major},tel = #{tel} where id = #{id}")
    int updateTeacher(Teacher teacher);
    @Update("update teacher set password = #{password} where id = #{id}")
    int updateTeacherPassword();
    @Delete("delete from teacher where id = #{id}")
    int deleteTeacherById(long id);

}
