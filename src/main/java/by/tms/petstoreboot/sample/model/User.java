package by.tms.petstoreboot.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String userName;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String firstName;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String lastName;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String password;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String phone;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private int userStatus;

}
