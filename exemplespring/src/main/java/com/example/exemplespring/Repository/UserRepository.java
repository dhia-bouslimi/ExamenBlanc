package com.example.exemplespring.Repository;

import com.example.exemplespring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByFNameAndLName(String f,String l);
}
