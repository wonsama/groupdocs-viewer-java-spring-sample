package com.groupdocs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: liosha
 * Date: 05.12.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/index.htm", method= RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", "Hello to sample application!");
        return "index";
    }
}
