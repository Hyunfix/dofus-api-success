package com.dofus.api.controller;

import com.dofus.api.dto.Data;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class SuccessController {

    private RestTemplate restTemplateSuccess;

    Logger log = LoggerFactory.getLogger(SuccessController.class);


    public SuccessController(final RestTemplateBuilder restTemplateBuilder){
        this.restTemplateSuccess = restTemplateBuilder.build();
    }

    @GetMapping("/success")
    public ResponseEntity<SuccessResponse> getSuccess(@RequestParam(value = "limit", defaultValue = "1") int limit, @RequestParam(value = "lang", required = false) String lang,@RequestParam(value = "categoryId", required = false) String categoryId,@RequestParam(value = "skip", required = false , defaultValue = "0")  int skip) {

        final SuccessResponse successResponse = new SuccessResponse();
        String successUrl = "https://api.dofusdb.fr/achievements?";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJpYXQiOjE2NDk3OTQwMzEsImV4cCI6MTY4MTMzMDAzMSwiYXVkIjoiaHR0cHM6Ly9kb2Z1c2RiLmZyIiwiaXNzIjoiZmVhdGhlcnMiLCJzdWIiOiI2MjU1ZGJlZWEzOGRmOTAwMTU0MGI1ZmEiLCJqdGkiOiI5ZjY4Y2M1Zi04ZDcwLTRiZmYtOTcwZi1jODIxMzU3ZGU3NzIifQ.AlPY6byNCmyUKP-qBr4HIJDAet8fGufKr-z2AcXmcgk");
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String urlTemplate = null;

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<SuccessResponse> response = null;

        if(limit > 1) {
        for (int i=0; i<58;i++) {
            if (i == 0) {
                urlTemplate = getUrlTemplate(urlTemplate, successUrl, skip, limit);
            } else {
                urlTemplate = UriComponentsBuilder.fromHttpUrl(successUrl)
                        .queryParam("$skip", skip + 50)
                        .queryParam("$limit", limit)
                        .encode()
                        .toUriString();
            }

            response = restTemplateSuccess.exchange(urlTemplate, HttpMethod.GET, entity, SuccessResponse.class);
            skip = response.getBody().getSkip();
            response.getBody().getDataList().stream().forEach(data -> {
                successResponse.addVariable(data);
            });
        }
         successResponse.setTotal(response.getBody().getTotal());
         successResponse.setLimit(response.getBody().getLimit());
         successResponse.setSkip(response.getBody().getSkip());
        }else {
            urlTemplate = getUrlTemplate(urlTemplate, successUrl, skip, limit);
            response = restTemplateSuccess.exchange(urlTemplate, HttpMethod.GET, entity, SuccessResponse.class);
            successResponse.setTotal(response.getBody().getTotal());
            successResponse.setLimit(response.getBody().getLimit());
            successResponse.setSkip(response.getBody().getSkip());
            successResponse.setDataList(response.getBody().getDataList());
        }

       return new ResponseEntity<SuccessResponse>(successResponse,HttpStatus.OK);
    }

    private String getUrlTemplate(String urlTemplate, String successUrl, int skip, int limit) {
        urlTemplate = UriComponentsBuilder.fromHttpUrl(successUrl)
                .queryParam("$skip", skip)
                .queryParam("$limit", limit)
                .encode()
                .toUriString();
        return urlTemplate;
    }
}

