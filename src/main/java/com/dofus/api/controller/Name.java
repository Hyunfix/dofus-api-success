package com.dofus.api.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {

    @JsonProperty("de")
    String de;

    @JsonProperty("en")
    String en;

    @JsonProperty("fr")
    String fr;


    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }
}
