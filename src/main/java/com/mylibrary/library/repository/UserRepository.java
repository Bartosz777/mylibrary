package com.mylibrary.library.repository;


import com.mylibrary.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long id);

    @Override
    void deleteById(Long id);

    Optional<User> findByUsername(String username);

}
