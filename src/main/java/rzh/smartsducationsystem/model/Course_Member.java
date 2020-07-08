package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Course_Member implements Serializable {
    private long id;
    private long stuId;
    private long course_Id;
    private String name;

    public Course_Member() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public long getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(long course_Id) {
        this.course_Id = course_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course_Member{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", course_Id=" + course_Id +
                ", name='" + name + '\'' +
                '}';
    }
}
