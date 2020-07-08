package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class Exam implements Serializable {
    private long id;
    private long course_Id;
    private String title;
    private List<Topic> topics;

    public Exam() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(long course_Id) {
        this.course_Id = course_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", course_Id=" + course_Id +
                ", title='" + title + '\'' +
                ", topics=" + topics +
                '}';
    }
}
