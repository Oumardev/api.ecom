package com.ecom.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.api.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    
}
