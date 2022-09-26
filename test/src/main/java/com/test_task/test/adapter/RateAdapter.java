package com.test_task.test.adapter;

import com.test_task.test.facade.RateFacade;
import com.test_task.test.mapper.Country2CountryResponseMapper;
import com.test_task.test.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RateAdapter {

    private final RateFacade rateFacade;
    private final Country2CountryResponseMapper country2CountryResponseMapper;

    public List<Country> getRateValues() {
        var countryList = rateFacade.getRateValue();
        return country2CountryResponseMapper.map(countryList);
    }
}
