package com.dofus.api.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class SuccessController {

    private RestTemplate restTemplateSuccess;

    Logger log = LoggerFactory.getLogger(SuccessController.class);

    public SuccessController(@Qualifier("restTemplateSuccess") RestTemplate restTemplateSuccess) {
        restTemplateSuccess = this.restTemplateSuccess;
    }

    @GetMapping("/success")
    public ResponseEntity<SuccessResponse> getSuccess(@RequestParam(value = "limit") int limit) {

        String successUrl = "https://api.dofusdb.fr/achievements";
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJpYXQiOjE2NDk3OTQwMzEsImV4cCI6MTY4MTMzMDAzMSwiYXVkIjoiaHR0cHM6Ly9kb2Z1c2RiLmZyIiwiaXNzIjoiZmVhdGhlcnMiLCJzdWIiOiI2MjU1ZGJlZWEzOGRmOTAwMTU0MGI1ZmEiLCJqdGkiOiI5ZjY4Y2M1Zi04ZDcwLTRiZmYtOTcwZi1jODIxMzU3ZGU3NzIifQ.AlPY6byNCmyUKP-qBr4HIJDAet8fGufKr-z2AcXmcgk");

            log.info("Header : {}", headers);

            MultiValueMap<String, Integer> params = new LinkedMultiValueMap<String, Integer>();
            params.add("$limit", limit);

            log.info("Params : {}", params);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            log.info("Entity : {}", entity);

            ResponseEntity<SuccessResponse> response = restTemplateSuccess.exchange(successUrl, HttpMethod.GET, entity, SuccessResponse.class, params);

            log.info("Response : {}", response.getBody());
            return response;
        } catch (Exception e) {
            log.error("Exception message : {} ", e.getMessage());
        }
    return null;
    }
}

