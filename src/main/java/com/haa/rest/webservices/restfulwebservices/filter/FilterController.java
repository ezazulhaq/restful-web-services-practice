package com.haa.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping(path = "/filter")
    public SomeBean filteringBean() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping(path = "/filter-list")
    public List<SomeBean> filteringListBean() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value11", "value22", "value33"));
    }
}
