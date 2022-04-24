package com.dofus.api.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ControllerUtils {

    public static String getUrlTemplate(String urlTemplate, String successUrl, int skip, int limit) {
        urlTemplate = UriComponentsBuilder.fromHttpUrl(successUrl)
                .queryParam("$skip", skip)
                .queryParam("$limit", limit)
                .encode()
                .toUriString();
        return urlTemplate;
    }
}
