package by.tms.petstoreboot.sample.resources;


import by.tms.petstoreboot.sample.model.Order;
import by.tms.petstoreboot.sample.model.Pet;
import by.tms.petstoreboot.sample.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/store")
public class StoreController {


    private StoreService storeService;

    @PostMapping(path = "/order") //place an order for a pet
    public Order placeAnOrder(@RequestBody Order order) {
        return storeService.placeAnOrderForAPet(order);
    }

    @GetMapping
    public List<Order> getAll(){
        return storeService.getOrders();
    }

    @GetMapping(path = "/order/{orderId}") //Find purchase order by ID
    public Order findPurchase(@PathVariable long orderId) {
        return storeService.findPurchaseOrderById(orderId);
    }

    @DeleteMapping(path = "/order/{orderId}") //Delete purchase order by ID
    public Boolean deletePurchase(@PathVariable long orderId) {
        return storeService.deletePurchaseOrderById(orderId);
    }

    @GetMapping(path = "/inventory/{petId}") //Returns pet inventories by status
    public Pet returnsPet(@PathVariable long petId) {
        return storeService.returnsPetInventoriesByStatus(petId);
    }

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

}
