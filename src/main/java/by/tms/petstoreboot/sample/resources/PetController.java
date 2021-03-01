package by.tms.petstoreboot.sample.resources;

import by.tms.petstoreboot.sample.model.Pet;
import by.tms.petstoreboot.sample.model.PetStatus;
import by.tms.petstoreboot.sample.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Valid
@RequestMapping(path = "/pet")
public class PetController {

    private PetService petService;

    @GetMapping
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @GetMapping(path = "/findByStatus") //Finds Pets by status
    public Pet findByStatus(@RequestParam PetStatus status) {
        return petService.findByStatus(status);
    }

    @GetMapping(path = "/{petId}") //Find pet by ID
    public Pet getById(@PathVariable long petId) {
        return petService.getPetById(petId);
    }

    /*@PostMapping(path = "/pet/{petId}") //Updates a pet in the store with form data*/

    @PostMapping(path = "/add")  //Add a new pet to the store
    public Pet newPet(@RequestBody Pet pet) {
        return petService.addNewPet(pet);
    }

    @PutMapping(path = "/update") //Update an existing pet
    public Pet update(@RequestBody Pet pet) {
        return petService.updatePet(pet);
    }

    @DeleteMapping(path = "/{petId}") //Deletes a pet
    public Boolean deletePetById(@PathVariable long petId) {
        return petService.deletePet(petId);
    }

    @Autowired
    public void setPetService(PetService petService) {
        this.petService = petService;
    }
}
