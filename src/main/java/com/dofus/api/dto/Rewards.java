package com.dofus.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Rewards {

    @JsonProperty("_id")
    private String _id;

    @JsonProperty("itemsRewards")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> itemsRewards = new ArrayList<>();

    @JsonProperty("itemsQuantityReward")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> itemsQuantityReward = new ArrayList<>();

    @JsonProperty("emotesReward")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> emotesReward = new ArrayList<>();

    @JsonProperty("spellsReward")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> spellsReward = new ArrayList<>();

    @JsonProperty("titlesReward")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> titlesReward = new ArrayList<>();

    @JsonProperty("ornamentsReward")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Integer> ornamentsReward = new ArrayList<>();

    @JsonProperty("id")
    private int id;

    @JsonProperty("achievementId")
    private int achievementId;

    @JsonProperty("criteria")
    private String criteria;

    @JsonProperty("kamaRatio")
    private Double kamaRatio;

    @JsonProperty("experienceRatio")
    private int experienceRatio;

    @JsonProperty("kamaScaleWithPlayerLevel")
    private boolean kamaScaleWithPlayerLevel;

    @JsonProperty("createdAt")
    LocalDateTime createdAt;

    @JsonProperty("updateAt")
    LocalDateTime updateAt;

    @JsonProperty("__v")
    int __v;

    @JsonProperty("_include")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<String> _include  = new ArrayList<>();

    @JsonProperty("items")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Items> items  = new ArrayList<>();

    @JsonProperty("ornaments")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Ornaments> ornaments  = new ArrayList<>();

    @JsonProperty("titles")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Titles> titles  = new ArrayList<>();

    public String get_id() {
        return _id;
    }

    public void set_id(String _id)
    {
        this._id = _id;
    }
    public List<Integer> getItemsRewards() {
        return itemsRewards;
    }

    public void setItemsRewards(List<Integer> itemsRewards) {
        this.itemsRewards = itemsRewards;
    }

    public List<Integer> getItemsQuantityReward() {
        return itemsQuantityReward;
    }

    public void setItemsQuantityReward(List<Integer> itemsQuantityReward) {
        this.itemsQuantityReward = itemsQuantityReward;
    }

    public List<Integer> getEmotesReward() {
        return emotesReward;
    }

    public void setEmotesReward(List<Integer> emotesReward) {
        this.emotesReward = emotesReward;
    }

    public List<Integer> getSpellsReward() {
        return spellsReward;
    }

    public void setSpellsReward(List<Integer> spellsReward) {
        this.spellsReward = spellsReward;
    }

    public List<Integer> getTitlesReward() {
        return titlesReward;
    }

    public void setTitlesReward(List<Integer> titlesReward) {
        this.titlesReward = titlesReward;
    }


    public List<Titles> getTitles() {
        return titles;
    }

    public void setTitles(List<Titles> titles) {
        this.titles = titles;
    }

    public List<Integer> getOrnamentsReward() {
        return ornamentsReward;
    }

    public void setOrnamentsReward(List<Integer> ornamentsReward) {
        this.ornamentsReward = ornamentsReward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Double getKamaRatio() {
        return kamaRatio;
    }

    public void setKamaRatio(Double kamaRatio) {
        this.kamaRatio = kamaRatio;
    }

    public int getExperienceRatio() {
        return experienceRatio;
    }

    public void setExperienceRatio(int experienceRatio) {
        this.experienceRatio = experienceRatio;
    }

    public boolean isKamaScaleWithPlayerLevel() {
        return kamaScaleWithPlayerLevel;
    }

    public void setKamaScaleWithPlayerLevel(boolean kamaScaleWithPlayerLevel) {
        this.kamaScaleWithPlayerLevel = kamaScaleWithPlayerLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public List<String> get_include() {
        return _include;
    }

    public void set_include(List<String> _include) {
        this._include = _include;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<Ornaments> getOrnaments() {
        return ornaments;
    }

    public void setOrnaments(List<Ornaments> ornaments) {
        this.ornaments = ornaments;
    }


}
