package com.test_task.test.rest;

import com.test_task.test.adapter.RateAdapter;
import com.test_task.test.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RateController {

    private final RateAdapter rateAdapter;

    @GetMapping("/value")
    public ResponseEntity<List<Country>> getHighestAndLowestValue() {
        var highestAndLowestValue = rateAdapter.getRateValues();
        return ResponseEntity.ok(highestAndLowestValue);
    }


}
