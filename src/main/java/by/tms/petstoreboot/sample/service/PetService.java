package by.tms.petstoreboot.sample.service;

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
        return null; //желательно сообщение
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
        return null; //сообщение
    }

    public Pet addNewPet(Pet pet) {
        if (petStorage.getPetList().contains(pet)) {
            return null;
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
            if (p.getId() == pet.getId()){
                p.setCategory(pet.getCategory());
                p.setName(pet.getName());
                p.setStatus(pet.getStatus());
                p.setTags(pet.getTags());
                return p;
            }
        }
        return null;
    }

    @Autowired
    public void setPetStorage(PetStorage petStorage) {
        this.petStorage = petStorage;
    }


}
