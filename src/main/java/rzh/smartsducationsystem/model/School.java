package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class School implements Serializable {
    private String schoolName;
    private long school_Id;

    public School(String schoolName, long school_Id) {
        this.schoolName = schoolName;
        this.school_Id = school_Id;
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + schoolName + '\'' +
                ", schoolId=" + school_Id +
                '}';
    }

    public School() {
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String name) {
        this.schoolName = name;
    }

    public long getSchool_Id() {
        return school_Id;
    }

    public void setSchool_Id(long id) {
        this.school_Id = id;
    }
}
