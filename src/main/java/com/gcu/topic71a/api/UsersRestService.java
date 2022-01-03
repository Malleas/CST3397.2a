package com.gcu.topic71a.api;

import com.gcu.topic71a.business.UserBusinessService;
import com.gcu.topic71a.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class UsersRestService {

    @Autowired
    UserBusinessService userBusinessService;

    @GetMapping ("/users")
    public ResponseEntity<?> getUsers(){
        try {
            List<UserModel> users = userBusinessService.getAllUsers();
            if(users == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(users, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
