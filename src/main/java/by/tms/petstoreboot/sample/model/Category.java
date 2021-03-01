package by.tms.petstoreboot.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String name;
}
