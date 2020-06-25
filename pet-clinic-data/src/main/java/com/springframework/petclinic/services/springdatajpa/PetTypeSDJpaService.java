package com.springframework.petclinic.services.springdatajpa;

import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.repositories.PetTypeRepositoty;
import com.springframework.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepositoty petTypeRepositoty;

    public PetTypeSDJpaService(PetTypeRepositoty petTypeRepositoty) {
        this.petTypeRepositoty = petTypeRepositoty;
    }

    @Override
    public Set<PetType> findAll() {

        Set<PetType> petTypes = new HashSet<>();
        petTypeRepositoty.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepositoty.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepositoty.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepositoty.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepositoty.delete(object);
    }
}
