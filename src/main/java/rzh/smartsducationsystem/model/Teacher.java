package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Teacher implements Serializable {
    private long id;
    private String name;
    private String school;
    private String department;
    private String password;
    private String major;
    private String tel;

    public Teacher() {
    }

    public Teacher(long id, String name, String school, String department, String password, String major, String tel) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.department = department;
        this.password = password;
        this.major = major;
        this.tel = tel;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
