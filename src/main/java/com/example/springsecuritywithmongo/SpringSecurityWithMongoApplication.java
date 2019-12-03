package com.example.springsecuritywithmongo;

import com.example.springsecuritywithmongo.Domain.User;
import com.example.springsecuritywithmongo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityWithMongoApplication implements CommandLineRunner {
@Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWithMongoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        User user=new User();
        user.setUserName("admin1");
        user.setPassword("admin");
        user.setEmail("admin@gmailw1.com" );
        user.setFirstName("lovedeep");
        user.setRoles("ROLE_ADMIN,ROLE_USER");
        user.setAccountLocked(false);
//userRepository.save(user);
    }
}
