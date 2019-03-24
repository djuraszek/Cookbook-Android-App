package com.cookbook.android.cookbook;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Recipe {

    private int recipeID;
    private String name;
    private double rating;
    private String portion;
    private String preparation;
    private ArrayList<Ingredient> ingredients;
    private Image image;


    public Recipe(int recipeID, String name, double rating, String portion, String preparation) {
        this.recipeID = recipeID;
        this.name = name;
        this.preparation = preparation;
        this.rating = rating;
        this.portion = portion;
        ingredients = new ArrayList<>();
    }

    public String toString(){
        return ""+name+", "+rating+", "+portion+", "+preparation;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Bitmap getImage() {
        return image.getBitmap();
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
