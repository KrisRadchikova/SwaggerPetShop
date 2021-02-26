package by.tms.petstoreboot.sample.storage;

import by.tms.petstoreboot.sample.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetStorage {

    private static final List<Pet> petList = new ArrayList<>();

    public List<Pet> getPetList() {
        return petList;
    }
}
