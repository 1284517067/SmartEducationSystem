package rzh.smartsducationsystem.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Work implements Serializable {
    private long id;
    private long course_Id;
    private Date begin;
    private Date end;
    private long job_Num;
    private String name;
    private Date limited_Time;

    public Work() {
    }
    public Work(long id, long course_Id, Date begin, Date end, long job_Num, String name, Date limited_Time) {
        this.id = id;
        this.course_Id = course_Id;
        this.begin = begin;
        this.end = end;
        this.job_Num = job_Num;
        this.name = name;
        this.limited_Time = limited_Time;
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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getJob_Num() {
        return job_Num;
    }

    public void setJob_Num(long job_Num) {
        this.job_Num = job_Num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLimited_Time() {
        return limited_Time;
    }

    public void setLimited_Time(Date limited_Time) {
        this.limited_Time = limited_Time;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", course_Id=" + course_Id +
                ", begin=" + begin +
                ", end=" + end +
                ", job_Num=" + job_Num +
                ", name='" + name + '\'' +
                ", limited_Time=" + limited_Time +
                '}';
    }
}
