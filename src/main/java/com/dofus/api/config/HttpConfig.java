package com.dofus.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class HttpConfig {

    /**
     * Bean RestTemplate pour les appels REST
     * @return
     */
    @Bean(name = "restTemplateSuccess")
    public RestTemplate getRestTemplate(){

        ClientHttpRequestFactory factory =
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(factory);

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new LoggingInterceptor());
        restTemplate.setInterceptors(interceptors);

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {

            @Override
            protected boolean hasError(HttpStatus statusCode) {
                return statusCode != HttpStatus.NOT_FOUND && super.hasError(statusCode);
            }
        });

        return restTemplate;
    }
}
