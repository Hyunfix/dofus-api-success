package com.dofus.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Objectives {

    @JsonProperty("_id")
    String _id;

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    List<Name> name;

    @JsonProperty("img")
    String img;

    @JsonProperty("_include")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Include> include;

    @JsonProperty("correspondingMiniBoss")
    String correspondingMiniBoss;

    @JsonProperty("correspondingNonMiniBoss")
    String correspondingNonMiniBoss;

    @JsonProperty("type")
    String type;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Include> getInclude() {
        return include;
    }

    public void setInclude(List<Include> include) {
        this.include = include;
    }

    public String getCorrespondingMiniBoss() {
        return correspondingMiniBoss;
    }

    public void setCorrespondingMiniBoss(String correspondingMiniBoss) {
        this.correspondingMiniBoss = correspondingMiniBoss;
    }

    public String getCorrespondingNonMiniBoss() {
        return correspondingNonMiniBoss;
    }

    public void setCorrespondingNonMiniBoss(String correspondingNonMiniBoss) {
        this.correspondingNonMiniBoss = correspondingNonMiniBoss;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
