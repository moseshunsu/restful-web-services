package com.higherAchievers.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class User {

    private int id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "Birth date should be in the past")
    @JsonProperty("birthDate")
    private LocalDate birthDate;

}
