package rzh.smartsducationsystem.service;

import org.springframework.stereotype.Service;
import rzh.smartsducationsystem.model.Student;

import java.util.List;
public interface StudentService {
    List<Student>findAll();
    boolean isStudentExist(long stuId);
    boolean addStudent(Student student);
    Student getStudentByStuId(long stuId);

}
