package com.example.springmvcview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @Author lanwp
 * @Date 2019/3/31
 */
@Controller
public class IndexController {

    @GetMapping({""})
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        // 这里的message1 比@ModelAttribute("message1")优先级高,
        // 页面显示此值，没有在这里设置属性则显示@ModelAttribute("message1")
        model.addAttribute("message1", "Hello World index"); // model.asMap().get("message1")
        return "index";
    }

    @ModelAttribute("message1")
    public String getMessage1() {
        return "Hello World message1";
    }
}
