package ua.test.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.test.spring_boot.Dao.UserDao;
import ua.test.spring_boot.Models.User;

import java.io.File;
import java.io.IOException;

@Service
public class UserServise {
    @Autowired
    private UserDao userDao;

    public void save(User user){
        userDao.save(user);
    }

    public void transferfile(MultipartFile file){
        String passtofolder = System.getProperty("user.home") + File.separator + "images" + File.separator;
        System.out.println(passtofolder);
        try {
            file.transferTo(new File(passtofolder + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
