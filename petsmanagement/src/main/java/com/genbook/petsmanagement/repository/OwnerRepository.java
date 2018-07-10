package com.genbook.petsmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.genbook.petsmanagement.domain.Owner;

@RepositoryRestResource
public interface OwnerRepository extends CrudRepository<Owner, Long>{

}
