package ua.test.spring_boot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.test.spring_boot.Dao.UserDao;

import ua.test.spring_boot.Models.Email;
import ua.test.spring_boot.Models.User;
import ua.test.spring_boot.service.UserServise;
import ua.test.spring_boot.service.editors.EmailEditor;

import javax.validation.Valid;

@Controller
public class Main_Controler {

    @Autowired
private UserDao userDao;
    @GetMapping("/")
    public String home(Model model){
//        model.addAttribute("users",userDao.findAll());
//        model.addAttribute("user",new User("test"));
        return "homeAsync";
    }

    @Autowired
    private UserServise servise;


    @PostMapping("/save")
    public String save (@Valid User user, BindingResult bindingResult, Model model,@RequestParam("picture")MultipartFile file){
//        if (bindingResult.hasErrors()){
//            servise.transferfile(file);
//            user.setPicture(file.getOriginalFilename());
//            servise.save(user);
//            return "homeAsync";
//        }

        return "homeAsync";
    }


    @Autowired
    private EmailEditor emailDoctor;
    @InitBinder("user")
    public void intBinder(WebDataBinder binder){
        binder.registerCustomEditor(Email.class,emailDoctor);
    }
}
