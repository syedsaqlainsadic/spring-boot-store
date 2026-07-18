package com.firstspringproject.store.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firstspringproject.store.entities.Cart;


public interface CartRepository extends JpaRepository<Cart, UUID> {

    @EntityGraph(attributePaths = "items.product")
    @Query(value = "select c from Cart c where c.id=:cartId")
    Optional<Cart>getCartWithItems(@Param("cartId")UUID cartId);

}
