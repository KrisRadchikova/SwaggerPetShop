package by.tms.petstoreboot.sample.service;

import by.tms.petstoreboot.sample.resources.exceptions.InvalidIDSuppliedException;
import by.tms.petstoreboot.sample.resources.exceptions.InvalidStatusValueException;
import by.tms.petstoreboot.sample.resources.exceptions.PetExistsException;
import by.tms.petstoreboot.sample.resources.exceptions.ValidationException;
import by.tms.petstoreboot.sample.model.Pet;
import by.tms.petstoreboot.sample.model.PetStatus;
import by.tms.petstoreboot.sample.storage.PetStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetStorage petStorage;

    public boolean contains(String name) {
        for (Pet pet : petStorage.getPetList()) {
            if (pet.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Pet findByStatus(PetStatus petStatus) {
        for (Pet pet : petStorage.getPetList()) {
            if (pet.getStatus().equals(petStatus)) {
                return pet;
            }
        }
        throw new InvalidStatusValueException("Invalid status value(pet)");
    }

    public List<Pet> getPets() {
        return petStorage.getPetList();
    }

    public Pet getPetById(long id) {
        for (Pet pet : petStorage.getPetList()) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        throw new InvalidIDSuppliedException("Invalid ID supplied(pet)");
    }

    public Pet addNewPet(Pet pet) {
        if (petStorage.getPetList().contains(pet)) {
            throw new PetExistsException("This pet exists");
        }
        petStorage.getPetList().add(pet);
        return pet;
    }

    public Boolean deletePet(long id) {
        petStorage.getPetList().removeIf(pet -> pet.getId() == id);
        return true;
    }

    public Pet updatePet(Pet pet) {
        for (Pet p : petStorage.getPetList()) {
            if (p.getId() == pet.getId()) {
                p.setCategory(pet.getCategory());
                p.setName(pet.getName());
                p.setStatus(pet.getStatus());
                p.setTags(pet.getTags());
                return p;
            }
        }
        throw new ValidationException("Validation exception(pet)");
    }

    @Autowired
    public void setPetStorage(PetStorage petStorage) {
        this.petStorage = petStorage;
    }


}
