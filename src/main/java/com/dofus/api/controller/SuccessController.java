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
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.Collections;

@RestController
public class SuccessController {

    private RestTemplate restTemplateSuccess;

    Logger log = LoggerFactory.getLogger(SuccessController.class);

    public SuccessController(@Qualifier("restTemplateSuccess") RestTemplate restTemplateSuccess) {
        restTemplateSuccess = this.restTemplateSuccess;
    }

    @GetMapping("/success")
    public ResponseEntity<SuccessResponse> getSuccess(@RequestParam(value = "limit", defaultValue = "1") int limit, @RequestParam(value = "lang", required = false) String lang,@RequestParam(value = "categoryId", required = false) String categoryId,@RequestParam(value = "skip", required = false , defaultValue = "0")  int skip) {

        String successUrl = "https://api.dofusdb.fr/achievements?";
        final SuccessResponse successResponse = new SuccessResponse();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJpYXQiOjE2NDk3OTQwMzEsImV4cCI6MTY4MTMzMDAzMSwiYXVkIjoiaHR0cHM6Ly9kb2Z1c2RiLmZyIiwiaXNzIjoiZmVhdGhlcnMiLCJzdWIiOiI2MjU1ZGJlZWEzOGRmOTAwMTU0MGI1ZmEiLCJqdGkiOiI5ZjY4Y2M1Zi04ZDcwLTRiZmYtOTcwZi1jODIxMzU3ZGU3NzIifQ.AlPY6byNCmyUKP-qBr4HIJDAet8fGufKr-z2AcXmcgk");
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            String urlTemplate = UriComponentsBuilder.fromHttpUrl(successUrl)
                    .queryParam("$skip", skip)
                    .queryParam("$limit", limit)
                    .encode()
                    .toUriString();

            log.info("Header : {}", headers);

            log.info("Url : {}", urlTemplate);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            log.info("Entity : {}", entity);

            ResponseEntity<SuccessResponse> response = restTemplateSuccess.exchange(urlTemplate, HttpMethod.GET, entity, SuccessResponse.class);
            successResponse.setData(response.getBody().getData());
            successResponse.setLimit(response.getBody().getLimit());
            successResponse.setTotal(response.getBody().getTotal());

            log.info("Response : {}", response.getBody());
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}

