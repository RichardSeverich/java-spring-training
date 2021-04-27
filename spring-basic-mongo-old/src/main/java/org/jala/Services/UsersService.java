package org.jala.Services;

import java.util.ArrayList;
import java.util.List;

import org.jala.models.UsersModel;
import org.jala.mongodb.UsersRepository;
import org.jala.support.Message;
import org.jala.support.MessageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private static final String ENTITY = "user";

    @Autowired
    private UsersRepository usersRepository;

    private List<UsersModel> myListUsers = new ArrayList<>();

    public List<UsersModel> getAllUsers() {
        myListUsers = usersRepository.findAll();
        return myListUsers;
    }

    public UsersModel getUserById(String id) {
        myListUsers.clear();
        myListUsers = usersRepository.findAll();
        //return myListUsers.stream().filter(user -> user.getId().equals(id)).findFirst().get();
        for (UsersModel user : myListUsers) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public Message addUser(UsersModel usersModel) {
        usersRepository.save(usersModel);
        return MessageManager.createdSuccessfully(ENTITY);
    }

    public Message updateUser(UsersModel usersModel, String id) {
        myListUsers.clear();
        myListUsers = usersRepository.findAll();
        for (int i = 0; i < myListUsers.size(); i++) {
            if (myListUsers.get(i).getId().equals(id)) {
                myListUsers.get(i).setId(usersModel.getId());
                myListUsers.get(i).setName(usersModel.getName());
                myListUsers.get(i).setLastName(usersModel.getLastName());
                myListUsers.get(i).setUserName(usersModel.getUserName());
                myListUsers.get(i).setEmail(usersModel.getEmail());
                usersRepository.save(myListUsers.get(i));
                return MessageManager.updatedSuccessfully(ENTITY);
            }
        }
        return MessageManager.entityDoesNotExist(ENTITY);
    }

    public Message deleteUser(String id) {
        myListUsers.clear();
        myListUsers = usersRepository.findAll();
        for (int i = 0; i < myListUsers.size(); i++) {
            if (myListUsers.get(i).getId().equals(id)) {
                usersRepository.delete(id);
                return MessageManager.deletedSuccessfully(ENTITY);
            }
        }
        return MessageManager.entityDoesNotExist(ENTITY);
    }
}
