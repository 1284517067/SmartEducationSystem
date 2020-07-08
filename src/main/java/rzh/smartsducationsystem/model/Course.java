package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Course implements Serializable {
    private long id;
    private String name;
    private String major;
    private String teacher;
    private String school;
    private double totalTime;

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    private String img;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Course(long id, String name, String major, String teacher, String school, double totalTime, String img) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.teacher = teacher;
        this.school = school;
        this.totalTime = totalTime;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", teacher='" + teacher + '\'' +
                ", school='" + school + '\'' +
                ", totalTime=" + totalTime +
                ", img='" + img + '\'' +
                '}';
    }

    public Course() {
    }
}
