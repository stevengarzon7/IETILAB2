package edu.eci.ieti.springboot.repository;

import edu.eci.ieti.springboot.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String>
{
    List<User> findByNameOrLastName(String name, String lastName);


    List<User> findByCreatedAtGreaterThan(Date date);
}