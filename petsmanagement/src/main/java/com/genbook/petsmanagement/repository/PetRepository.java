package com.genbook.petsmanagement.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.genbook.petsmanagement.domain.Pet;

@RepositoryRestResource
public interface PetRepository extends CrudRepository<Pet, Long>{

}
