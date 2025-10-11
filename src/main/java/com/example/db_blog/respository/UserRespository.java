package com.example.db_blog.respository;

import com.example.db_blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
