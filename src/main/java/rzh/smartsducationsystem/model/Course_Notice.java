package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class Course_Notice implements Serializable {
    private long id;
    private long course_Id;
    private String name;//教师姓名
    private String content;
    private long job_Num;
    private Date publish;

    public Course_Notice() {
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

    @Override
    public String toString() {
        return "Course_Notice{" +
                "id=" + id +
                ", course_Id=" + course_Id +
                ", teacher_Name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", job_Num=" + job_Num +
                ", publish=" + publish +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String teacher_Name) {
        this.name = teacher_Name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getJob_Num() {
        return job_Num;
    }

    public void setJob_Num(long job_Num) {
        this.job_Num = job_Num;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }
}
