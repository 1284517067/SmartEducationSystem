package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class Topic implements Serializable {
    private long id;
    private long exam_Id;
    private String topic_content;
    private String answer;
    private List<Option> options;

    public Topic() {
    }

    public Topic(String topic_content, String answer, List<Option> options) {
        this.topic_content = topic_content;
        this.answer = answer;
        this.options = options;
    }

    public Topic(long id, long exam_Id, String topic_content, String answer, List<Option> options) {
        this.id = id;
        this.exam_Id = exam_Id;
        this.topic_content = topic_content;
        this.answer = answer;
        this.options = options;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getExam_Id() {
        return exam_Id;
    }

    public void setExam_Id(long exam_Id) {
        this.exam_Id = exam_Id;
    }

    public String getTopic_content() {
        return topic_content;
    }

    public void setTopic_content(String topic_content) {
        this.topic_content = topic_content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", exam_Id=" + exam_Id +
                ", topic_content='" + topic_content + '\'' +
                ", answer='" + answer + '\'' +
                ", options=" + options +
                '}';
    }
}
