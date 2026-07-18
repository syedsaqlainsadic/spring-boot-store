package com.firstspringproject.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;


import com.firstspringproject.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    // To fetch the profile whose loyalty point greater than a certain value

    @EntityGraph(attributePaths = { "user" })
    List<Profile> findByLoyaltyPointsGreaterThan(Integer loyaltyPoints);

    

}
