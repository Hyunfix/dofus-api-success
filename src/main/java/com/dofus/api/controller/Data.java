package com.dofus.api.controller;


import com.fasterxml.jackson.annotation.JsonProperty;

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
}
