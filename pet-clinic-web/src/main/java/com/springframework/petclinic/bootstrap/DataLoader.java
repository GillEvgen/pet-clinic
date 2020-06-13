package com.springframework.petclinic.bootstrap;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.model.Vet;
import com.springframework.petclinic.services.OwnerService;
import com.springframework.petclinic.services.PetTypeService;
import com.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mick");
        owner1.setLastName("Smith");
        owner1.setAddress("1234 GOBK");
        owner1.setCity("Brest");
        owner1.setTelephone("737377373");

        Pet evgenDog = new Pet();
        evgenDog.setPetType(saveDogPetType);
        evgenDog.setOwner(owner1);
        evgenDog.setBirthDate(LocalDate.now());
        evgenDog.setName("Mike");
        owner1.getPets().add(evgenDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nick");
        owner2.setLastName("Rock");
        owner2.setAddress("1234 GOBK");
        owner2.setCity("Brest");
        owner2.setTelephone("737377373");

        Pet mollyCat = new Pet();
        mollyCat.setName("Hloy");
        mollyCat.setPetType(saveCatPetType);
        mollyCat.setOwner(owner2);
        mollyCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(mollyCat);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Alex");
        vet1.setLastName("Mim");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Prast");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
