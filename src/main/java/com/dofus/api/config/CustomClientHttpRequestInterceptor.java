package com.dofus.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {


    private static Logger log = LoggerFactory
            .getLogger(CustomClientHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] reqBody,
            ClientHttpRequestExecution execution) throws IOException {

        logRequestDetails(request);

        logResponseDetails(request, reqBody, execution);

        return execution.execute(request, reqBody);
    }

    private void logResponseDetails(HttpRequest request, byte[] reqBody, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, reqBody);
        InputStreamReader isr = new InputStreamReader(
                response.getBody(), StandardCharsets.UTF_8);
        String body = new BufferedReader(isr).lines()
                .collect(Collectors.joining("\n"));
        log.info("Response body: {}", body);
    }

    private void logRequestDetails(HttpRequest request) {
        log.info("Headers: {}", request.getHeaders());
        log.info("Request Method: {}", request.getMethod());
        log.info("Request URI: {}", request.getURI());
    }


}
