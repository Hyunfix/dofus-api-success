package com.dofus.api.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@RestController
public class SuccessController {

    private RestTemplate restTemplateSuccess;

    Logger log = LoggerFactory.getLogger(SuccessController.class);

    public SuccessController(@Qualifier("restTemplateSuccess") RestTemplate restTemplateSuccess) {
        restTemplateSuccess = this.restTemplateSuccess;
    }

    @GetMapping("/success")
    public ResponseEntity<SuccessResponse> getSuccess(@RequestParam(value = "limit") int limit, @RequestParam(value = "lang", required = false) String lang,@RequestParam(value = "categoryId", required = false) String categoryId,@RequestParam(value = "skip", required = false)  int skip) {

        String successUrl = "https://api.dofusdb.fr/achievements?";
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJpYXQiOjE2NDk3OTQwMzEsImV4cCI6MTY4MTMzMDAzMSwiYXVkIjoiaHR0cHM6Ly9kb2Z1c2RiLmZyIiwiaXNzIjoiZmVhdGhlcnMiLCJzdWIiOiI2MjU1ZGJlZWEzOGRmOTAwMTU0MGI1ZmEiLCJqdGkiOiI5ZjY4Y2M1Zi04ZDcwLTRiZmYtOTcwZi1jODIxMzU3ZGU3NzIifQ.AlPY6byNCmyUKP-qBr4HIJDAet8fGufKr-z2AcXmcgk");
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Accept","application/json");

            log.info("Header : {}", headers);

            log.info("Url : {}", successUrl);

            MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
            params.add("$limit", limit);
            if(StringUtils.isNotBlank(lang)){
                params.add("lang",lang);
            }
            if(StringUtils.isNotBlank(categoryId)){
                params.add("categoryId", categoryId);;
            }
            params.add("skip", skip);

            log.info("Params : {}", params);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            log.info("Entity : {}", entity);
            
            ResponseEntity<SuccessResponse> response = restTemplateSuccess.exchange(successUrl, HttpMethod.GET, entity, SuccessResponse.class,params);

            log.info("Response : {}", response.getBody());
            return response;
        } catch (Exception e) {
            log.error("Exception message : {} ", e.getMessage());
        }
        return null;
    }
}

