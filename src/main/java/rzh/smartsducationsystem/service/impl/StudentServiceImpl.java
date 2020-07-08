package rzh.smartsducationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rzh.smartsducationsystem.dao.StudentDao;
import rzh.smartsducationsystem.model.Student;
import rzh.smartsducationsystem.service.StudentService;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean isStudentExist(long stuId) {
        boolean flag = false;
        Student student = studentDao.getStudentByStuId(stuId);
        if (student != null){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean addStudent(Student student) {
        boolean flag = false;
        int i = studentDao.addStudent(student);
        if (i != 0)
        {
            flag = true;
        }
        return flag;
    }

    @Override
    public Student getStudentByStuId(long stuId)
    {
        Student student = studentDao.getStudentByStuId(stuId);
        return student;
    }
}
