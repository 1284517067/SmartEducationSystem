package rzh.smartsducationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rzh.smartsducationsystem.bean.BeanFactory;
import rzh.smartsducationsystem.bean.UserBean;
import rzh.smartsducationsystem.dao.AdminDao;
import rzh.smartsducationsystem.dao.StudentDao;
import rzh.smartsducationsystem.dao.TeacherDao;
import rzh.smartsducationsystem.model.Admin;
import rzh.smartsducationsystem.model.Student;
import rzh.smartsducationsystem.model.Teacher;
import rzh.smartsducationsystem.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    AdminDao adminDao;

    @Override
    public boolean validateAccount(UserBean userBean) {
        switch (userBean.getUserType()){
            case "student":
                Student student = BeanFactory.getStudent();
                student.setStuId(Long.parseLong(userBean.getUsername()));
                student.setPassword(userBean.getPassword());
                Student student1 = studentDao.getStudentByStuId(student.getStuId());
                if (student1 != null){
                    String pwd = student1.getPassword();
                    if (pwd.isEmpty()||pwd=="")
                    {
                        return false;
                    }else {
                        if (student.getPassword().equals(student1.getPassword())){
                            return true;
                        }else {
                            return false;
                        }
                    }
                }else {
                    return false;
                }
            case "teacher":
                Teacher teacher = BeanFactory.getTeacher();
                teacher.setId(Long.parseLong(userBean.getUsername()));
                teacher.setPassword(userBean.getPassword());
                Teacher teacher1 = teacherDao.getTeacherById(teacher.getId());
                if (teacher1 != null) {
                    if (teacher.getPassword().equals(teacher1.getPassword())){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            case "admin":
                Admin admin = BeanFactory.getAdmin();
                admin.setUsername(userBean.getUsername());
                admin.setPassword(userBean.getPassword());
                Admin admin1 = adminDao.getAdminByUsername(admin.getUsername());
                if (admin1 != null){
                    if (admin.getPassword().equals(admin1.getPassword())){
                        return true;
                    }else {
                        return false;
                    }
                }else
                {
                    return false;
                }

        }
        return false;
    }

    @Override
    public Object getUser(UserBean userBean) {
        switch (userBean.getUserType()){
            case "student" :
                Student student = studentDao.getStudentByStuId(Long.parseLong(userBean.getUsername()));
                return student;
            case "teacher" :
                Teacher teacher = teacherDao.getTeacherById(Long.parseLong(userBean.getUsername()));
                return teacher;
            case "admin" :
                Admin admin = adminDao.getAdminByUsername(userBean.getUsername());
                return admin;
        }
        return null;
    }
}
