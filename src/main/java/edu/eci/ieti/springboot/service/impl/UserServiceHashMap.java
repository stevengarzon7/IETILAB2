package edu.eci.ieti.springboot.service.impl;
import edu.eci.ieti.springboot.data.User;
import edu.eci.ieti.springboot.service.UserService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class UserServiceHashMap implements UserService {

    private final HashMap<String,User> userhashmap= new HashMap<>();
    private static final AtomicInteger counter = new AtomicInteger(1);

    @Override
    public User create(User user) {
        for (User u: userhashmap.values()) {
            if(u.getName()==user.getName() && u.getEmail()==user.getEmail() && u.getLastName()==user.getLastName()){
                throw new RuntimeException("Create user error.");
            }else{
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                user.setId(String.valueOf(counter.getAndIncrement()));
                user.setCreatedAt(format.format(new Date()));
                userhashmap.put(user.getId(), user);
            }
        }

        return user;
    }

    @Override
    public User findById(String id) {
        return userhashmap.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userhashmap.values());
    }

    @Override
    public void deleteById(String id) {
        userhashmap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        if (userhashmap.containsKey(userId))
        {
            user.setId(userId);
            user.setCreatedAt(userhashmap.get(userId).getCreatedAt());
            userhashmap.replace(userId, user);
            return user;
        }else
        {
            return null;
        }
    }
}