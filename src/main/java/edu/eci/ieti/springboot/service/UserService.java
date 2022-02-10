package edu.eci.ieti.springboot.service;

import edu.eci.ieti.springboot.data.User;
import edu.eci.ieti.springboot.dto.UserDto;

import java.util.Date;
import java.util.List;

public interface UserService
{
    User create( User user );

    User findById( String id );

    List<User> getAll();

    boolean deleteById( String id );

    User update(UserDto userDto, String userId );
    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);
}
