package com.hfad.builderpattern.TutorialClasses;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private static final String DEBUG_TAG = "tag";

    //Create a list to hold ingredients
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    //Calculate total calories
    public void getCalories(){
        int c = 0;

        for(Ingredient i : ingredients){
            c += i.calories();
        }
        Log.d(DEBUG_TAG, "Total calories : " + c + " kcal");
    }

    //Add ingredient
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    //Output ingredients
    public void getSandwich(){
        for(Ingredient i : ingredients){
            Log.d(DEBUG_TAG,i.name() + " : " + i.calories() + " kcal");
        }
    }
/*
    public static void main(String[] args) {
        //Build a customizes sandwich
        SandwichBuilder builder = new SandwichBuilder();
        Sandwich custom = new Sandwich();
        //Simulate user selections
        custom = builder.build(custom,new Bagel());
        custom = builder.build(custom,new Baguette());
        Log.d(DEBUG_TAG,"CUSTOMIZED");
        custom.getSandwich();
        custom.getCalories();

        //Build a ready made sandwich
        Sandwich offTheShelf = SandwichBuilder.readyMade();
        Log.d(DEBUG_TAG,"READY MADE");
        offTheShelf.getSandwich();
        offTheShelf.getCalories();
    }

 */

}
