package com.higherAchievers.rest.webservices.restfulwebservices.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Getter
@ToString
public class PersonV2 {

    @Autowired
    private Name name;

}
