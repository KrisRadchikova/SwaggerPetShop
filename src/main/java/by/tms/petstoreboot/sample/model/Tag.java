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
public class Tag {

    private int id;

    @NotEmpty
    @NotBlank
    @Size(min = 2)
    private String name;
}
