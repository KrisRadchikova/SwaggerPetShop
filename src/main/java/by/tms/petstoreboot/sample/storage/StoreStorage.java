package by.tms.petstoreboot.sample.storage;

import by.tms.petstoreboot.sample.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreStorage {

    private static final List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }
}
