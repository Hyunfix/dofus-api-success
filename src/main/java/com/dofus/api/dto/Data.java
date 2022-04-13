package com.dofus.api.dto;


import com.dofus.api.dto.Name;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe data success
 */
public class Data {

    @JsonProperty("_id")
    String _id;

    @JsonProperty("objectiveIds")
    List<Integer> objectiveIds;

    @JsonProperty("rewardIds")
    List<Integer> rewardIds;

    @JsonProperty("id")
    String id;

    @JsonProperty("nameId")
    String nameId;

    @JsonProperty("name")
    List<Name> name;

    @JsonProperty("categoryId")
    int categoryId;

    @JsonProperty("descriptionId")
    int descriptionId;

    @JsonProperty("description")
    List<Description> description;

    @JsonProperty("iconId")
    int iconId;

    @JsonProperty("points")
    int points;


    @JsonProperty("level")
    int level;

    @JsonProperty("order")
    int order;

    @JsonProperty("accountLinked")
    boolean accountLinked;

    @JsonProperty("createdAt")
    LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    LocalDateTime updatedAt;

    @JsonProperty("__v")
    int __v;

    @JsonProperty("slug")
    List<Slug> slug;

    @JsonProperty("img")
    String img;

    @JsonProperty("_include")
    List<Include> _include;

    @JsonProperty("objectives")
    List<Objectives> objectives;
}
