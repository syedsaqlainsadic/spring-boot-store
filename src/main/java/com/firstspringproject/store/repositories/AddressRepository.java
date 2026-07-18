package com.firstspringproject.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.firstspringproject.store.entities.Address;

public interface AddressRepository  extends CrudRepository<Address , Long>{

}
