package com.haa.rest.webservices.restfulwebservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World!!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWroldBean helloWorldbean() {
        return new HelloWroldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-world/path-var/{name}")
    public HelloWroldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWroldBean(String.format("Hello World, Welcome to %s", name));
    }
}
