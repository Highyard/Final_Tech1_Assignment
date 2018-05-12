package com.example.demo.Controller;

import com.example.demo.Services.ChildRepositoryImpl;
import com.example.demo.domain.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    ChildRepositoryImpl childRepository;

    @GetMapping ("/")
    public String home(){
        return "home";
    }
    @GetMapping ("/home")
    public String home2(){
        return "home";
    }
    @GetMapping ("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping ("/user")
    public String user (){
        return "user";
    }
    @GetMapping ("/login")
    public String login(){
        return "login";
    }
    @GetMapping ("/403")
    public String error403(){
        return "/error/403";
    }
    @GetMapping ("/about")
    public String about(){
        return "about";
    }

    @GetMapping ("/phonelist")
    public String phonelist(Model model){

        model.addAttribute("children", childRepository.readAllChildren());
        System.out.println(childRepository.readAllChildren());
        return "phonelist";
    }

    @GetMapping ("/create")
    public String create(Model model) {

        model.addAttribute("child", new Child());

        return "create";
    }

    @PostMapping ("/create")
    public String create(@ModelAttribute Child child){

        childRepository.addChild(child);

        System.out.println("child was added");

        return "redirect:/phonelist";
    }
}
