package com.dofus.api.controller;


import com.dofus.api.dto.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Retour du service Success
 */
public class SuccessResponse {

    @JsonProperty("total")
    int total;

    @JsonProperty("limit")
    int limit;

    @JsonProperty("skip")
    int skip;

    @JsonProperty("data")
    List<Data> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
