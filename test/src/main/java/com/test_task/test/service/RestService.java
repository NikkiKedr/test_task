package com.test_task.test.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;
    private static final String VAT_RATES_URL = "http://5.189.172.205:15500/vat-rates";

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostPlainJSON(){
        return restTemplate.getForObject(VAT_RATES_URL, String.class);
    }
}
