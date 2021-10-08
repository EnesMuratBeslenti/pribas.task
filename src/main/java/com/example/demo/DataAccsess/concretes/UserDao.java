package com.example.demo.DataAccsess.concretes;

import com.example.demo.Entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User,Long> {
      User findByPasswordAndEmail(String password, String email);

}