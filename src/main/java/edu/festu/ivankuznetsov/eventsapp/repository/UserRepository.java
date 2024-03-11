package edu.festu.ivankuznetsov.eventsapp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.festu.ivankuznetsov.eventsapp.model.User;
import jakarta.transaction.Transactional;


public interface UserRepository extends JpaRepository<User, UUID> {
    
    @Transactional
    @Query("SELECT t FROM User t LEFT JOIN FETCH t.roles where t.email = ?1")
    Optional<User> findByEmail(String email);
}
