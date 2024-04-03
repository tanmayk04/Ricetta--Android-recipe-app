package com.app.ricetta;

public class Recipe {
    public String id;
    public int recipeId;
    public int categoryId;
    public String name;
    public String imUrl;
    public String cookingTime;
    public float rating;

    public Recipe(int recipeId, int categoryId, String name, String imUrl, String cookingTime, float rating) {
        this.recipeId = recipeId;
        this.categoryId = categoryId;
        this.name = name;
        this.imUrl = imUrl;
        this.cookingTime = cookingTime;
        this.rating = rating;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getImUrl() {
        return imUrl;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public float getRating() {
        return rating;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImUrl(String imUrl) {
        this.imUrl = imUrl;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
