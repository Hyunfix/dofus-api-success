package com.dofus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Description {

    @JsonProperty("de")
    String de;

    @JsonProperty("en")
    String en;

    @JsonProperty("fr")
    String fr;

}
