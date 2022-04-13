package com.dofus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Rewards {

    @JsonProperty("_id")
    private String _id;

    @JsonProperty("itemsRewards")
    private List<ItemsReward> itemsRewards = new ArrayList<>();

    @JsonProperty("itemsQuantityReward")
    private List<ItemsQuantityReward> itemsQuantityReward = new ArrayList<>();

    @JsonProperty("emotesReward")
    private List<EmotesReward> emotesReward = new ArrayList<>();

    @JsonProperty("spellsReward")
    private List<SpellsReward> spellsReward = new ArrayList<>();

    @JsonProperty("titlesReward")
    private List<TitlesRewards> titlesReward = new ArrayList<>();

    @JsonProperty("ornamentsReward")
    private List<OrnamentsReward> ornamentsReward = new ArrayList<>();

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
    List<Include> _include  = new ArrayList<>();

    @JsonProperty("items")
    List<Items> items  = new ArrayList<>();

    @JsonProperty("ornaments")
    List<Ornaments> ornaments  = new ArrayList<>();

    @JsonProperty("titles")
    List<Titles> titles  = new ArrayList<>();

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<ItemsReward> getItemsRewards() {
        return itemsRewards;
    }

    public void setItemsRewards(List<ItemsReward> itemsRewards) {
        this.itemsRewards = itemsRewards;
    }

    public List<ItemsQuantityReward> getItemsQuantityReward() {
        return itemsQuantityReward;
    }

    public void setItemsQuantityReward(List<ItemsQuantityReward> itemsQuantityReward) {
        this.itemsQuantityReward = itemsQuantityReward;
    }

    public List<EmotesReward> getEmotesReward() {
        return emotesReward;
    }

    public void setEmotesReward(List<EmotesReward> emotesReward) {
        this.emotesReward = emotesReward;
    }

    public List<SpellsReward> getSpellsReward() {
        return spellsReward;
    }

    public void setSpellsReward(List<SpellsReward> spellsReward) {
        this.spellsReward = spellsReward;
    }

    public List<TitlesRewards> getTitlesReward() {
        return titlesReward;
    }

    public void setTitlesReward(List<TitlesRewards> titlesReward) {
        this.titlesReward = titlesReward;
    }

    public List<OrnamentsReward> getOrnamentsReward() {
        return ornamentsReward;
    }

    public void setOrnamentsReward(List<OrnamentsReward> ornamentsReward) {
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

    public List<Include> get_include() {
        return _include;
    }

    public void set_include(List<Include> _include) {
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

    public List<Titles> getTitles() {
        return titles;
    }

    public void setTitles(List<Titles> titles) {
        this.titles = titles;
    }
}
