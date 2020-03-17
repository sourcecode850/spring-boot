package com.example.spring.eventandjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    //Declare query at the query method using @Query
    @Query("select u from UserEntity u where u.username = ?1")
    UserEntity findByUsername(String username);

}