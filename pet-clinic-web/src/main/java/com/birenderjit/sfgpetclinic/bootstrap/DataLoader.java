package com.birenderjit.sfgpetclinic.bootstrap;

import com.birenderjit.sfgpetclinic.model.Owner;
import com.birenderjit.sfgpetclinic.model.Vet;
import com.birenderjit.sfgpetclinic.services.OwnerService;
import com.birenderjit.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Marco");
        owner1.setLastName("Polo");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Matt");
        owner2.setLastName("Damon");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Tom");
        vet2.setLastName("Ford");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
