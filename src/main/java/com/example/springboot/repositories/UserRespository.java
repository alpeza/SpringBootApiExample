package com.example.springboot.repositories;

import com.example.springboot.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user",nativeQuery = true)
    List<User> findAllUsers();

    @Query(value = "select * from user where name=:userName",nativeQuery = true)
    List<User> findUserByName(@Param("userName") String userName);

}
