package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Study_Record implements Serializable {
    private long id;
    private long course_Id;
    private long stuId;
    private double already;

    public Study_Record() {
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

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public double getAlready() {
        return already;
    }

    public void setAlready(double already) {
        this.already = already;
    }

    @Override
    public String toString() {
        return "Study_Record{" +
                "id=" + id +
                ", course_Id=" + course_Id +
                ", stuId=" + stuId +
                ", already=" + already +
                '}';
    }
}
