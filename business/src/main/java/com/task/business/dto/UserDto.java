package com.task.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.task.business.entity.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class UserDto {

    private Long id;
    @Size(min = 2, max = 20,
            message = "Login must be between 2 and 20 characters")
    private String login;
    @Min(value = 8, message = "Password must be at least 8 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    private Set<Role> roles;
}
