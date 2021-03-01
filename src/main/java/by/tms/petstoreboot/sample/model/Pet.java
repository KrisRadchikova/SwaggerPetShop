package by.tms.petstoreboot.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private long id;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private Category category;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String name;

    private PetStatus status;

    @NotEmpty
    @NotBlank
    private List<Tag> tags;

}
