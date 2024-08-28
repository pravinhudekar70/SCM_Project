package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "Username is required")
    @Size(min = 3,message = "Min 3 Character is required")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email Address")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Min 6 Charecter is required")
    private String password;
    @NotBlank(message = "About is required")
    private String about;
    @NotBlank
    @Size(min =8, max = 12, message = "Invalid Number")
    private String phoneNumber;
}
