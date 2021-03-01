package by.tms.petstoreboot.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private long id;
    private long petId;
    private long userId;

    @NotEmpty
    @NotBlank
    @Size(min = 1)
    private int quantity;

    private LocalDateTime shipDate;
    private PetStatus petStatus;
    private OrderStatus orderStatus;
    private boolean complete;


}
