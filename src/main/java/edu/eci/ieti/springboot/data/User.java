package edu.eci.ieti.springboot.data;

import edu.eci.ieti.springboot.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
public class User {
    @Id
    private String id;
    private String name;

    @Indexed( unique = true )
    private String email;
    private String lastName;
    private String createdAt;


    public User(String id) {
        this.id = id;
    }
    public User(UserDto userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.lastName = userDTO.getLastName();
    }

    public User(String id, String name, String email, String lastName, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public void update(UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }

}