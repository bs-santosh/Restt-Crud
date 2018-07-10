package com.genbook.petsmanagement.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.genbook.petsmanagement.domain.Owner;
import com.genbook.petsmanagement.domain.Pet;
import com.genbook.petsmanagement.repository.OwnerRepository;
import com.genbook.petsmanagement.repository.PetRepository;
import com.genbook.petsmanagement.util.Utils;

@Component
public class PetsManagementRunner implements CommandLineRunner{
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private PetRepository petRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Owner own1 = new Owner();
		own1.setFirstName("Santosh");
		own1.setLastName("Hegde");
		own1.setCity("Sydney");
		
		
		List<Pet> petList = new ArrayList<Pet>();
		Pet pet1 = new Pet();
		pet1.setName("Ritchy");
		pet1.setBirthday(Utils.buildDateObjFromStringDate("10-03-2012"));
		petList.add(pet1);
		pet1.setOwner(own1);
		
		Pet pet2 = new Pet();
		pet2.setName("Billy");
		pet2.setBirthday(Utils.buildDateObjFromStringDate("10-03-2012"));
		pet2.setOwner(own1);
		petList.add(pet2);
		own1.setOwnedPets(petList);
		ownerRepository.save(own1);
		
		Owner own2 = new Owner();
		own2.setFirstName("Scott");
		own2.setLastName("Benson");
		own2.setCity("Melbourne");
		List<Pet> petsList2 = new ArrayList<Pet>();
		Pet pet3 = new Pet();
		pet3.setName("Jimmy");
		pet3.setBirthday(Utils.buildDateObjFromStringDate("10-05-2010"));
		pet3.setOwner(own2);
		petsList2.add(pet3);
		own2.setOwnedPets(petsList2);
		ownerRepository.save(own2);
		
		Owner own3 = new Owner();
		own3.setFirstName("Stefen");
		own3.setLastName("Smidt");
		own3.setCity("Sydney");
		List<Pet> petsList3 = new ArrayList<Pet>();
		Pet pet4 = new Pet();
		pet4.setName("Jimmy");
		pet4.setBirthday(Utils.buildDateObjFromStringDate("10-03-2012"));
		pet4.setOwner(own2);
		petsList3.add(pet4);
		own3.setOwnedPets(petsList3);
		ownerRepository.save(own3);
	}
}
