package com.techelevator.Services;

import com.techelevator.model.SaleTaxDto;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TaxServices {

    public final String API_BASE = "https://teapi.netlify.app/api/statetax?state=";

    private RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getSalesTax(String stateCode) {

        String url = API_BASE + "https://teapi.netlify.app/api/statetax?state=" + stateCode;
        SaleTaxDto saleTaxDto = restTemplate.getForObject(url,SaleTaxDto.class);
         return saleTaxDto.getSalesTax().divide(new BigDecimal(100));
    }

    }

