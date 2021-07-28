package com.haa.rest.webservices.restfulwebservices.util;

import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

@Component
public class Utilities implements IUtilities {

    @Override
    public MappingJacksonValue filterResultsFromData(Object result, String filterName, String... fieldsToFilter) {

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToFilter);

        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);

        MappingJacksonValue mapping = new MappingJacksonValue(result);
        mapping.setFilters(filters);

        return mapping;
    }

    @Override
    public MappingJacksonValue filterResultsFromList(List<?> result, String filterName, String... fieldsToFilter) {

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToFilter);

        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);

        MappingJacksonValue mapping = new MappingJacksonValue(result);
        mapping.setFilters(filters);

        return mapping;
    }

}
