package com.haa.rest.webservices.restfulwebservices.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonContoller {

    @GetMapping(path = "/v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Ezazul Haq");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Ezazul Haq", "Abdul"));
    }

}
