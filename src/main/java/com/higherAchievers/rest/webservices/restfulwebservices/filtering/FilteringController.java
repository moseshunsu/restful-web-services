package com.higherAchievers.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    public <E> MappingJacksonValue mappingJacksonValue(E e) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(e);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering") //filtered out field 2
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        return mappingJacksonValue(someBean);
    }

    @GetMapping("/filtering-list") //filtered out field1, field3
    public MappingJacksonValue filteringList() {

        List<SomeBean> list = List.of(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));

        return mappingJacksonValue(list);
    }

}
