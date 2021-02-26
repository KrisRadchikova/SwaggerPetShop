package by.tms.petstoreboot.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private long id;
    private Category category;
    private String name;
    private PetStatus status;
    private List<Tag> tags;

}
