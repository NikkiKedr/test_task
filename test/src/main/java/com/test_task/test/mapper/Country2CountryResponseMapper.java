package com.test_task.test.mapper;

import com.test_task.test.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Country2CountryResponseMapper {

    public List<Country> map(List<String> from){
        List<Country> countryList = new ArrayList<>(from.size());
        for (String string : from){
            Country country = Country.builder().countryName(string).build();
            countryList.add(country);
        }
        return countryList;
    }

}
