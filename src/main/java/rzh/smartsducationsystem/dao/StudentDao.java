package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Student;

import java.util.List;

@Repository
@Mapper
public interface StudentDao {
    @Select("select * from student")
    List<Student> getStudentList();
    @Select("select * from student where school = #{school} and department = #{department} and major = #{major} and classes = #{classes}")
    List<Student> getStudentByClasses(String school,String department,String major,String classes);
    @Select("select * from student where school = #{school} and department = #{department} and major = #{major}")
    List<Student> getStudentByMajor(String school,String department,String major);
    @Select("select * from student where stuId = #{stuId}")
    Student getStudentByStuId(long stuId);
    @Insert("insert into student(stuId,password,name,school,department,major,classes,tel,studyTime) values (#{stuId},#{password},#{name},#{school},#{department},#{major},#{classes},#{tel},#{studyTime})")
    int addStudent(Student student);
    @Update("update student set password = #{password},name = #{name},school = #{school},department = #{department},major = #{major},classes = #{classes},tel = #{tel},studyTime = #{studyTime} where stuId = #{stuId}")
    int updateStudent(Student student);
    @Update("update student set password = #{password} where stuId = #{stuId}")
    int updateStudentPassword(Student student);
    @Delete("delete from student where stuId = #{stuId}")
    int deleteStudentByStuId(long stuId);
    @Select("select password from student where stuId = #{stuId}")
    String getStudentPasswordByStuId(long stuId);
}
