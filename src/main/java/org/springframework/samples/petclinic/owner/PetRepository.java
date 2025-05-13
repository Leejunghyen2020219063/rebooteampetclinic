package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface PetRepository extends Repository<Pet, Integer> {

	@Query("SELECT pt FROM PetType pt")
	List<PetType> findPetTypes();

	Pet findById(int id) throws DataAccessException;

	void save(Pet pet) throws DataAccessException;

	List<Pet> findByOwner(Owner owner);

	Page<Pet> findAll();
}
