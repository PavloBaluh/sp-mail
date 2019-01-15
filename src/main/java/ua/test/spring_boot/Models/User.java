package ua.test.spring_boot.Models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "emails")
@Entity
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
@Size(min = 3,max = 6,message = "hello its {massage}")
 private String name;

 @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "user")
 private List<Email> emails = new ArrayList<>();
 private String picture;

 public User(String name) {
  this.name = name;
 }

}

