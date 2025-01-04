package com.hot3.userService.Repository;

import com.hot3.userService.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    public User findByEmail(String email);
}
