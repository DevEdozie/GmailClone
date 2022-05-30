package com.hfad.builderpattern.TutorialClasses;

public abstract class Bread implements Ingredient {
   @Override
    public abstract String name();

   @Override
    public abstract int calories();
}
