package ua.test.spring_boot.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.test.spring_boot.Models.User;

@RestController
public class AsyncControllers {


    @PostMapping("/saveAsync")
    public void Async (@RequestBody User user){
        System.out.println("reakt");
        System.out.println(user);
    }
}
