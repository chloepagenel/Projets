package com.epitech.dashboard.repository;

import com.epitech.dashboard.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer>{
    List<User> findByName(String name);
    User findById(long id);
}
