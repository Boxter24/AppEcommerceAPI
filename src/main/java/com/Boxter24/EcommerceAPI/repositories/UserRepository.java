package com.Boxter24.EcommerceAPI.repositories;

import com.Boxter24.EcommerceAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select user from User user where user.email = :email")
    User findUserActive(String email);

}
