package com.gcu.topic71a.business;

import com.gcu.topic71a.data.entity.UserEntity;
import com.gcu.topic71a.data.repository.UsersRepository;
import com.gcu.topic71a.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBusinessService {

    @Autowired
    private UsersRepository usersRepository;

    public UserBusinessService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UserModel> getAllUsers(){
        List<UserEntity> userEntities = usersRepository.findAll();
        List<UserModel> users = new ArrayList<>();
        for(UserEntity user : userEntities){
            users.add(new UserModel(user.getID(), user.getUsername(), user.getPassword()));
        }
        return users;
    }
}
