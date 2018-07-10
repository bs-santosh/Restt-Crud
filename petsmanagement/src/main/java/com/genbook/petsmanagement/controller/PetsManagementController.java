package com.genbook.petsmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genbook.petsmanagement.constants.Messages;
import com.genbook.petsmanagement.domain.Owner;
import com.genbook.petsmanagement.domain.Pet;
import com.genbook.petsmanagement.dto.OwnerResponse;
import com.genbook.petsmanagement.dto.PetRequest;
import com.genbook.petsmanagement.dto.PetResponse;
import com.genbook.petsmanagement.repository.OwnerRepository;
import com.genbook.petsmanagement.repository.PetRepository;

@Controller
public class PetsManagementController {
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private PetRepository petRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get-owners")
	@ResponseBody
	public OwnerResponse getAllOwnerEntries(){
		Iterable<Owner> ownerList = ownerRepository.findAll();
		OwnerResponse response = new OwnerResponse();
		if(ownerList == null){
			response.setErrorMessage(Messages.NO_OWNER_RECORDS);
		}else{
			response.setOwners((List<Owner>) ownerList);
		}
		return response;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get-pets")
	@ResponseBody
	public PetResponse getAllPetEntries(){
		System.out.println("Inside get pet entries");
		Iterable<Pet> petList = petRepository.findAll();
		PetResponse response = new PetResponse();
		if(petList == null){
			response.setErrorMessage(Messages.NO_PET_RECORDS);
		}else{
			response.setPets((List<Pet>) petList);
		}
		return response;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/create-pet")
	@ResponseBody
	public String createPet(@RequestBody PetRequest request){
		if(StringUtils.isEmpty(request.getName())){
			return Messages.INCOMPLETE_DATA;
		}else{
			Pet pet = new Pet();
			Pet savedPet;
			pet.setName(request.getName());
			try{
				pet.setBirthday(request.getDateOfBirth());
			}catch(Exception ex){
				return Messages.INVALID_DATE;
			}
			savedPet = petRepository.save(pet);
			
			Owner owner = new Owner();
			if(StringUtils.isEmpty(request.getOwnerFirstName())
					&& !StringUtils.isEmpty(request.getOwnerLastName())){
				return Messages.INCOMPLETE_OWNER_DETAILS;
			}else if(StringUtils.isEmpty(request.getOwnerFirstName())){
				return Messages.PET_CREATED_SUCESSFULLY;
			}
			else{
				owner.setFirstName(request.getOwnerFirstName());
				owner.setLastName(request.getOwnerLastName());
				owner.setCity(request.getOwnerCity());
				Owner savedOwner = ownerRepository.save(owner);
				
				savedPet.setOwner(savedOwner);
				petRepository.save(savedPet);
			}
		}
		return Messages.PET_CREATED_SUCESSFULLY;
	}
}
