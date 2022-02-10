package edu.eci.ieti.springboot.controller;

import edu.eci.ieti.springboot.data.User;
import edu.eci.ieti.springboot.dto.UserDto;
import edu.eci.ieti.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;
@RestController
@RequestMapping( "/user" )
public class UserController
{

    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return ResponseEntity.ok( userService.getAll() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.findById( id ) );
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( new User( userDto ) ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }

    @GetMapping( "/queryNameOrLastName/{queryText}")
    public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike( @PathVariable String queryText )
    {
        return ResponseEntity.ok( userService.findUsersWithNameOrLastNameLike(queryText) );
    }

    @PostMapping( "/date")
    public ResponseEntity<List<User>> findUserCreatedAfter( @RequestBody Date startDate )
    {

        return ResponseEntity.ok( userService.findUsersCreatedAfter(startDate) );
    }





}