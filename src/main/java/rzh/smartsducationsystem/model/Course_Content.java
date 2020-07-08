package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

@Component
public class Course_Content {
    private long id;
    private long course_Id;
    private String name;//名字
    private String element;//单元
    private String node;//节
    private String intro;//简介
    private String content;//内容
    private double duration;//时长

    public Course_Content() {
    }

    @Override
    public String toString() {
        return "Course_Content{" +
                "id=" + id +
                ", course_Id=" + course_Id +
                ", content_Name='" + name + '\'' +
                ", element='" + element + '\'' +
                ", node='" + node + '\'' +
                ", intro='" + intro + '\'' +
                ", content='" + content + '\'' +
                ", duration=" + duration +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
