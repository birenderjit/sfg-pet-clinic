package com.birenderjit.sfgpetclinic.repositories;

import com.birenderjit.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
