package org.jala.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Richard Severich on 28/10/2017.
 */
@Document(collection = "Users")
public class UsersModel {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String userName;
    private String email;

    /**
     * Public default constructor.
     */
    public UsersModel() {

    }

    public UsersModel(String id, String name, String lastName, String userName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
