package com.example.pp_3_1_1_spring_boot.service;

import com.example.pp_3_1_1_spring_boot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> getAllUsers ();
    User getUserById(Long id);
    void save(User user);
    void removeUser(Long id);

}
