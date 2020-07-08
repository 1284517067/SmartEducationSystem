package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Work;

import java.util.List;

@Repository
@Mapper
public interface WorkDao {
    @Select("select * from work")
    List<Work> getWorkList();
    @Select("select * from work where id = #{id}")
    Work getWorkById(long id);
    @Select("select * from work where course_Id = #{course_Id}")
    List<Work> getWorkByCourse_Id(long course_Id);
    @Insert("insert into work (course_Id,begin,end,job_Num,limited_Time) values (#{course_Id},#{begin},#{end},#{job_Num},#{name},#{limited_Time})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insertWork(Work work);
}
