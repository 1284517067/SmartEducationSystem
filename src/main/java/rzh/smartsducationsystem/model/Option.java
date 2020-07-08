package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Option implements Serializable {
    private long id;
    private long topic_Id;
    private String option;
    private String option_content;

    public Option() {
    }

    public Option(long topic_Id, String option, String option_content) {
        this.topic_Id = topic_Id;
        this.option = option;
        this.option_content = option_content;
    }

    public Option(long id, long topic_Id, String option, String option_content) {
        this.id = id;
        this.topic_Id = topic_Id;
        this.option = option;
        this.option_content = option_content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTopic_Id() {
        return topic_Id;
    }

    public void setTopic_Id(long topic_Id) {
        this.topic_Id = topic_Id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOption_content() {
        return option_content;
    }

    public void setOption_content(String option_content) {
        this.option_content = option_content;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", topic_Id=" + topic_Id +
                ", option='" + option + '\'' +
                ", option_content='" + option_content + '\'' +
                '}';
    }
}
