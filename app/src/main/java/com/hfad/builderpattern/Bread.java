package com.hfad.builderpattern;

public abstract class Bread implements Ingredient {
   @Override
    public abstract String name();

   @Override
    public abstract int calories();
}
