package rzh.smartsducationsystem.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rzh.smartsducationsystem.model.Course;
import rzh.smartsducationsystem.model.Teacher;
import rzh.smartsducationsystem.service.WorkService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CreateWorkController {

    @Autowired
    WorkService workService;

    @RequestMapping(value = "/createWork")
    public String toCreateWork(){
        return "createWork";
    }
    @RequestMapping(value = "/createWork/submit")
    public String toSubmit(String jsonData, HttpServletRequest request){
        HttpSession session = request.getSession();
        Course course = (Course)session.getAttribute("course");
        Teacher teacher = (Teacher)session.getAttribute("user");
        workService.createWork(jsonData,course,teacher);

        return "createWork";
    }
}
