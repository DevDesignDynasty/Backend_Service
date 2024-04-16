package com.devdesign.backend.services;

import com.devdesign.backend.entities.User;
import com.devdesign.backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Boolean addUser(String token){
        //check if user exists with given token
        User user = userRepo.findByToken(token);
        if (user == null){
            user = new User();
            user.setToken(token);
            user.setQuizCompleted(false);
            userRepo.save(user);
            return true;
        }else {
            if(user.isQuizCompleted()){
                return false;
            }else {
                return true;
            }

        }


    }
    public Boolean submitQuiz(String token){
        User user = userRepo.findByToken(token);
        if (user != null){
            user.setQuizCompleted(true);
            userRepo.save(user);
            return true;
        }else {
            return false;
        }

    }

    public User getUser(String id){
        try {
            return userRepo.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }

    public String quizStatus(String token){
        try {
            User user = userRepo.findByToken(token);
            return String.valueOf(user.isQuizCompleted());
        }catch (Exception e){
            return "User not found";
        }

    }


}
