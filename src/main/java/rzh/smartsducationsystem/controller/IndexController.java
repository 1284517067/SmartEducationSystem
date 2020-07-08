package rzh.smartsducationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = "/t")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/t2")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @RequestMapping("/")
    public String runAnswer(Model model){
        model.addAttribute("answer","来自后端");
        return "index";
    }
}
