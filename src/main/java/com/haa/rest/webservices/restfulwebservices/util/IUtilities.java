package com.haa.rest.webservices.restfulwebservices.util;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;

public interface IUtilities {

    public MappingJacksonValue filterResultsFromData(Object result, String filterName, String... fieldsToFilter);

    public MappingJacksonValue filterResultsFromList(List<?> result, String filterName, String... fieldsToFilter);

}
