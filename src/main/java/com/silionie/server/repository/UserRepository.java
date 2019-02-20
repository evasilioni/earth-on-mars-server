package com.silionie.server.repository;

import com.silionie.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    User findByColonistId(String colonistId);

    @Query("select u from User u where u.colonistId = :colonistId and u.password = :password")
    User findByUsernameAndPassword(@Param("colonistId") String colonistId,@Param("password") String password );
}
