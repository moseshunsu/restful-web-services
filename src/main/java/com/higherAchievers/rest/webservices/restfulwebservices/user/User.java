package com.higherAchievers.rest.webservices.restfulwebservices.user;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class User {

    private int id;
    private String name;
    private LocalDate birthDate;

}
