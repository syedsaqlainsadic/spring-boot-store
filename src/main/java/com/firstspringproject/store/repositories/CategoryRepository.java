package com.firstspringproject.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.firstspringproject.store.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Byte> {

}
