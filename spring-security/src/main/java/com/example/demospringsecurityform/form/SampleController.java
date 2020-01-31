package com.example.demospringsecurityform.form;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * SampleController
 */     
@Controller
public class SampleController {
    

    @GetMapping(value="/")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "hello spring security");
        } else {
            model.addAttribute("message", "hello " +  principal.getName());
        }
        return "index";
    }                   
    @GetMapping(value="/info")
    public String info(Model model) {
        model.addAttribute("message", "info");
        return "info";
    }
    @GetMapping(value="/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "hello " +  principal.getName());
        return "dashboard";
    }
    @GetMapping(value="/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "hello admin " +  principal.getName());
        return "admin";
    }
}