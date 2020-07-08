package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Course_Content;

import java.util.List;

@Repository
@Mapper
public interface Course_ContentDao {
    @Select("select * from course_content")
    List<Course_Content>getCourse_ContentList();
    @Select("select * from course_content where course_Id = #{course_Id}")
    List<Course_Content>getCourse_ContentByCourse_Id(long course_Id);
    @Select("select * from course_content where id = #{id}")
    Course_Content getCourse_ContentById(long id);
    @Update("update course_content set course_Id = #{course_Id},name = #{name},element = #{element},node = #{node},intro = #{intro},content = #{content},duration = #{duration} where id = #{id}")
    int updateCourse_Content(Course_Content course_content);
    @Insert("insert into course_content (course_Id,name,element,node,intro,content,duration) values (#{course_Id},#{name},#{element},#{node},#{intro},#{content},#{duration})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int addCourse_Content(Course_Content course_content);
    @Delete("delete from course_content where id = #{id}")
    int deleteCourse_ContentById(long id);
}
