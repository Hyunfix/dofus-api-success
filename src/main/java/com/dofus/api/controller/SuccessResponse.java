package com.dofus.api.controller;


import com.dofus.api.dto.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Retour du service Success
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessResponse implements Serializable {

    @JsonProperty("total")
    int total;

    @JsonProperty("limit")
    int limit;

    @JsonProperty("skip")
    int skip;

    @JsonProperty("data")
    List<Data> dataList = new ArrayList<>();

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

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void addVariable(Data data){
        this.dataList.add(data);
    }


    @Override
    public String toString() {
        return "SuccessResponse{" +
                "total=" + total +
                ", limit=" + limit +
                ", skip=" + skip +
                ", dataList=" + dataList +
                '}';
    }
}
