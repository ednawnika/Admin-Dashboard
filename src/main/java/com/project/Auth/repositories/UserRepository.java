package com.project.Auth.repositories;

import com.project.Auth.models.User;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
    User findByUsername(String username);
    List<User> findAll();
    
    User findById(Long id);
   
}

