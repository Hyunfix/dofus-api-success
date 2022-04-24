package com.dofus.api.controller;

import com.dofus.api.dto.Data;
import com.dofus.api.utils.ControllerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
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

    @Value("${spring.api.token}")
    private String token;


    public SuccessController(final RestTemplateBuilder restTemplateBuilder){
        this.restTemplateSuccess = restTemplateBuilder.build();
    }

    @GetMapping("/success")
    public ResponseEntity<SuccessResponse> getSuccess(@RequestParam(value = "limit", defaultValue = "1") int limit, @RequestParam(value = "lang", required = false) String lang,@RequestParam(value = "categoryId", required = false) String categoryId,@RequestParam(value = "skip", required = false , defaultValue = "0")  int skip,@RequestParam(value = "recupList", required = false , defaultValue = "false")  boolean recupList) {

        final SuccessResponse successResponse = new SuccessResponse();
        String successUrl = "https://api.dofusdb.fr/achievements?";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String urlTemplate = null;

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<SuccessResponse> response = null;
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        final List<Data> dataList = new ArrayList<>();

        urlTemplate = ControllerUtils.getUrlTemplate(urlTemplate, successUrl, skip, limit);
        response = restTemplateSuccess.exchange(urlTemplate, HttpMethod.GET, entity, SuccessResponse.class);
        successResponse.setTotal(response.getBody().getTotal());
        successResponse.setLimit(response.getBody().getLimit());
        successResponse.setSkip(response.getBody().getSkip());
        successResponse.setDataList(response.getBody().getDataList());


        response = restTemplateSuccess.exchange(urlTemplate, HttpMethod.GET, entity, SuccessResponse.class);

        skip = response.getBody().getSkip();

        successResponse.setTotal(response.getBody().getTotal());
        successResponse.setLimit(response.getBody().getLimit());
        successResponse.setSkip(response.getBody().getSkip());
        successResponse.setDataList(dataList);

        long timeResponse = endTime - startTime;
        log.debug("Temps de réponse: {}  ",  timeResponse,  "ms");
       return new ResponseEntity<SuccessResponse>(successResponse,HttpStatus.OK);
    }


}

