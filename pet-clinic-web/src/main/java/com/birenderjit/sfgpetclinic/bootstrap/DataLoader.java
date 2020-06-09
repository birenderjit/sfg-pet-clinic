package com.birenderjit.sfgpetclinic.bootstrap;

import com.birenderjit.sfgpetclinic.model.*;
import com.birenderjit.sfgpetclinic.services.OwnerService;
import com.birenderjit.sfgpetclinic.services.PetTypeService;
import com.birenderjit.sfgpetclinic.services.SpecialityService;
import com.birenderjit.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Marco");
        owner1.setLastName("Polo");
        owner1.setAddress("123 Poplar Ave");
        owner1.setCity("Memphis");
        owner1.setTelephone("99988887777");

        Pet marcosPet = new Pet();
        marcosPet.setPetType(savedDogPetType);
        marcosPet.setOwner(owner1);
        marcosPet.setBirthDate(LocalDate.now());
        marcosPet.setName("Bugger");
        owner1.getPets().add(marcosPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        owner2.setAddress("111 Pike Ave");
        owner2.setCity("Memphis");
        owner2.setTelephone("99989897777");

        Pet janesPet = new Pet();
        janesPet.setPetType(savedCatPetType);
        janesPet.setOwner(owner2);
        janesPet.setBirthDate(LocalDate.now());
        janesPet.setName("Mishka");
        owner2.getPets().add(janesPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tom");
        vet2.setLastName("Ford");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
