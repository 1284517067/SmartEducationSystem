package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Student implements Serializable {
    private long stuId;
    private String password;
    private String name;
    private String school;
    private String department;
    private String major;
    private String classes;
    private String tel;
    private double studyTime;

    public Student() {
    }

    public Student(long stuId, String password, String name, String school, String department, String major, String classes, String tel, double studyTime) {
        this.stuId = stuId;
        this.password = password;
        this.name = name;
        this.school = school;
        this.department = department;
        this.major = major;
        this.classes = classes;
        this.tel = tel;
        this.studyTime = studyTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", tel=" + tel +
                ", studyTime=" + studyTime +
                '}';
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(double studyTime) {
        this.studyTime = studyTime;
    }
}
