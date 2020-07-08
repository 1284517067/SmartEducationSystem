package rzh.smartsducationsystem.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import rzh.smartsducationsystem.model.Topic;

import java.util.List;

@Repository
@Mapper
public interface TopicDao {
    @Select("select * from topic")
    List<Topic> getTopicList();
    @Select("select * from topic where id = #{id}")
    Topic getTopicById(long id);
    @Select("select + from topic where exam_Id = #{exam_Id}")
    List<Topic> getTopicListByExam_Id(long exam_Id);
    @Insert("insert into topic (topic_content,answer) values (#{topic_content},#{answer})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void insertTopic(Topic topic);
    @Update("update topic set exam_Id = #{exam_Id},topic_content = #{topic_content},answer = #{answer} where id = #{id}")
    int updateTopicById(Topic topic);

}
