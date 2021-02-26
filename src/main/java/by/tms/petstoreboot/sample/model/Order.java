package by.tms.petstoreboot.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private long id;
    private long petId;
    private long userId;
    private int quantity;
    private String shipDate;
    private PetStatus petStatus;
    private OrderStatus orderStatus;
    private boolean complete;


}
