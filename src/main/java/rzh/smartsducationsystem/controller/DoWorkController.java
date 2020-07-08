package rzh.smartsducationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoWorkController {
    @RequestMapping(value = "/doWork")
    public String toDoWork(){
        return "doWork";
    }
}
