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

    @JsonProperty("category")
    List<Category> category;

    @JsonProperty("rewards")
    List<Rewards> rewards;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Integer> getObjectiveIds() {
        return objectiveIds;
    }

    public void setObjectiveIds(List<Integer> objectiveIds) {
        this.objectiveIds = objectiveIds;
    }

    public List<Integer> getRewardIds() {
        return rewardIds;
    }

    public void setRewardIds(List<Integer> rewardIds) {
        this.rewardIds = rewardIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isAccountLinked() {
        return accountLinked;
    }

    public void setAccountLinked(boolean accountLinked) {
        this.accountLinked = accountLinked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public List<Slug> getSlug() {
        return slug;
    }

    public void setSlug(List<Slug> slug) {
        this.slug = slug;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Include> get_include() {
        return _include;
    }

    public void set_include(List<Include> _include) {
        this._include = _include;
    }

    public List<Objectives> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objectives> objectives) {
        this.objectives = objectives;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Rewards> getRewards() {
        return rewards;
    }

    public void setRewards(List<Rewards> rewards) {
        this.rewards = rewards;
    }
}
