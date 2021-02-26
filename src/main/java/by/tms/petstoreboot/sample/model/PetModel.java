package by.tms.petstoreboot.sample.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetModel {
    private int id;
    private String name;
    private PetStatus petStatus;
}
