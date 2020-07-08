package rzh.smartsducationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rzh.smartsducationsystem.bean.BeanFactory;
import rzh.smartsducationsystem.model.Student;
import rzh.smartsducationsystem.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register/submit")
    public String register(String school, String stuId, String password, String department, String major, String tel, String name, String classes, HttpServletRequest request){
        HttpSession session = request.getSession();
        Student student = BeanFactory.getStudent(Long.parseLong(stuId),password,name,school,department,classes,major,tel);
        if (!studentService.isStudentExist(student.getStuId())){
            boolean flag = studentService.addStudent(student);
            if (flag){
                session.setAttribute("user",studentService.getStudentByStuId(student.getStuId()));
                System.out.println("success");
                return "index";
            }else {
                session.setAttribute("hasMsg",true);
                session.setAttribute("msg","Register failed(Add student failed.)");
                System.out.println("Register failed(Add student failed.)");
                return "register";
            }
        }else {
            session.setAttribute("hasMsg",true);
            session.setAttribute("msg","Register failed(stuId is not exist.)");
            System.out.println("Register failed(stuId is exist.)");
            return "register";
        }



    }

}
