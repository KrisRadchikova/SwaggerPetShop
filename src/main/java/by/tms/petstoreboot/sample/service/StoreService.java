package by.tms.petstoreboot.sample.service;

import by.tms.petstoreboot.sample.resources.exceptions.OrderNotFoundException;
import by.tms.petstoreboot.sample.model.Order;
import by.tms.petstoreboot.sample.model.Pet;
import by.tms.petstoreboot.sample.model.PetStatus;
import by.tms.petstoreboot.sample.storage.StoreStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private StoreStorage storeStorage;

    private PetService petService;

    public List<Order> getOrders() {
        return storeStorage.getOrderList();
    }

    public Order placeAnOrderForAPet(Order order) {
        storeStorage.getOrderList().add(order);
        petService.getPetById(order.getId()).setStatus(PetStatus.PENDING);
        return order;
    }

    public Order findPurchaseOrderById(long id) {
        for (Order order : storeStorage.getOrderList()) {
            if (order.getId() == id) {
                return order;
            }
        }
        throw new OrderNotFoundException("Order not found");
    }

    public Boolean deletePurchaseOrderById(long id) {
        List<Order> orders = storeStorage.getOrderList();
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(order);
                returnsPetInventoriesByStatus(order.getPetId());
                return true;
            }
        }
        return false;
    }

    public Pet returnsPetInventoriesByStatus(long petId) {
        Pet pet = petService.getPetById(petId);
        pet.setStatus(PetStatus.AVAILABLE);
        return pet;
    }


    @Autowired
    public void setStoreStorage(StoreStorage storeStorage) {
        this.storeStorage = storeStorage;
    }

    @Autowired
    public void setPetService(PetService petService) {
        this.petService = petService;
    }
}
