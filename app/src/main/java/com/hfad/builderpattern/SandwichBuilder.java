package com.hfad.builderpattern;

public class SandwichBuilder {

    //Off the shelf sandwich
    public static Sandwich readyMade(){
        Sandwich sandwich = new Sandwich();

        sandwich .addIngredient(new Bagel());
        sandwich .addIngredient(new SmokedSalmon());
        sandwich .addIngredient(new Tomato());

        return sandwich;

    }

    //Customized sandwich
    public static Sandwich build(Sandwich s, Ingredient i){

        s.addIngredient(i);
        return s;
    }

}
