package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.School;

import java.util.List;

@Repository
@Mapper
public interface SchoolDao {
    @Select("select * from school")
    List<School> getSchoolList();
    @Update("update school set schoolName = #{schoolName} where school_Id = #{school_Id}")
    int updateSchool(School school);
    @Insert("insert into school (schoolName) values (#{schoolName})")
    @Options(useGeneratedKeys = true,keyProperty = "school_Id")
    int addSchool(School school);
    @Delete("delete from school where school_Id = #{school_Id}")
    int deleteSchoolBySchool_Id(long school_Id);
}
