package com.firstspringproject.store.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.firstspringproject.store.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = { "addresses" })
    Optional<User>findByEmail(String email);

    @EntityGraph(attributePaths = { "tags", "addresses" })
    @Query("SELECT u FROM User u")
    List<User> findAllWithAddresses();

    boolean existsByEmail(String email);

    // @Query("SELECT u.id as id, u.email as email FROM User u  WHERE u.profile.loyaltyPoints > :loyaltyPoints ORDER BY u.email ASC")
    // List<UserSummary> findLoyaltyUsers(@Param("loyaltyPoints") Integer loyaltyPoints);
}
