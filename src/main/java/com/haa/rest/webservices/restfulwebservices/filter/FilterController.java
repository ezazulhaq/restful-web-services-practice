package com.haa.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import com.haa.rest.webservices.restfulwebservices.util.IUtilities;
import com.haa.rest.webservices.restfulwebservices.util.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @Autowired
    private IUtilities utilities;

    @GetMapping(path = "/filter")
    public MappingJacksonValue filteringBean() {

        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        return utilities.filterResultsFromData(someBean, "SomeBeanFilter", "field1");
    }

    @GetMapping(path = "/filter-list")
    public MappingJacksonValue filteringListBean() {

        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value11", "value22", "value33"));

        return utilities.filterResultsFromList(list, "SomeBeanFilter", "field1", "field3");
    }
}
