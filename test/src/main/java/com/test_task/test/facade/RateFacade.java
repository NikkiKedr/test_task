package com.test_task.test.facade;

import com.test_task.test.use_case.GetRateValuesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateFacade {

    private final GetRateValuesUseCase getRateValuesUseCase;

    public List<String> getRateValue() {
        return getRateValuesUseCase.execute();
    }
}
