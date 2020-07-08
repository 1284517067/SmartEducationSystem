package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Option;

import java.util.List;

@Repository
@Mapper
public interface OptionDao {
    @Select("select * from option")
    List<Option> getOptionList();
    @Select("select * from option where topic_Id = #{topic_Id}")
    List<Option> getOptionListByTopic_Id(long topic_Id);
    @Insert("insert into option (topic_Id,option,option_content) values (#{topic_Id},#{option},#{option_content})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void insertOption(Option option);
    @Update("update option set topic_Id = #{topic_id},option = #{option},option_content = #{option_content} where id = #{id}")
    int updateOptionById(long id);
}
