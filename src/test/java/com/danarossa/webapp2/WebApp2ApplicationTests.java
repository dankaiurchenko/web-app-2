package com.danarossa.webapp2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApp2ApplicationTests {


    @Test
    public void contextLoads() {
//        Stream.of(userRepository.findAll())
//                .map((user) -> (User) user)
//                .peek((user) -> System.out.println(user.getUserId()))
//                .filter((user) -> user.getUserId() < 66)
//                .peek((user) -> System.out.println(user.getUserId()))
//                .forEach(userRepository::save);
////        userRepository.findAll();
////        for (User user : userRepository.findAll()){
////            if(user.getUserId() < 66){
////                user.setPassword(user.getPassword());
////                userRepository.save(user);
////            }
////        }

    }

}
