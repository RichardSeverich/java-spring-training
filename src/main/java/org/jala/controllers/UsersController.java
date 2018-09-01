package org.jala.controllers;

import org.jala.Services.UsersService;
import org.jala.models.UsersModel;
import org.jala.support.Message;
import org.jala.support.MessageManager;
import org.jala.support.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET, value = Paths.BASE_PATH_USERS)
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = Paths.BASE_PATH_USERS_WITH_ID)
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        if (usersService.getUserById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MessageManager.entityDoesNotExist("user"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getUserById(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = Paths.BASE_PATH_USERS)
    public ResponseEntity<?> addUser(@RequestBody UsersModel usersModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.addUser(usersModel));
    }

    @RequestMapping(method = RequestMethod.PUT, value = Paths.BASE_PATH_USERS_WITH_ID)
    public ResponseEntity<?> updateUser(@RequestBody UsersModel usersModel, @PathVariable String id) {
        Message message = usersService.updateUser(usersModel, id);
        if (message.getCode().equals("202")) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = Paths.BASE_PATH_USERS_WITH_ID)
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        Message message = usersService.deleteUser(id);
        if (message.getCode().equals("200")) {
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
