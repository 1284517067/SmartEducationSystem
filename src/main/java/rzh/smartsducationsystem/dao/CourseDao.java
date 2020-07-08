package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Course;

import java.util.List;

@Repository
@Mapper
public interface CourseDao {
    @Select("select * from course")
    List<Course>getCourseList();
    @Select("select * from course where major = #{major}")
    List<Course>getCourseByMajor(String major);
    @Select("select * from course where id = #{id}")
    Course getCourseById(long id);
    @Insert("insert into course (id,name,major,jobNum,school,totalTime,img) values (#{id},#{name},#{major},#{jobNum},#{school},#{totalTime},#{img})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int addCourse(Course course);
    @Update("update course set name = #{name},major = #{major},jobNum = #{jobNum},school = #{school},totalTime = #{totalTime},img = #{img} where id = #{id}")
    int updateCourse(Course course);
    @Delete("delete from course where id = #{id}")
    int deleteCourseById(long id);

}
