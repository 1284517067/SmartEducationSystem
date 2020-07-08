package rzh.smartsducationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateCourseController {

    @RequestMapping(value = "/updateCourse")
    public String toUpdateCourse(){
        return "updateCourse";
    }
}
