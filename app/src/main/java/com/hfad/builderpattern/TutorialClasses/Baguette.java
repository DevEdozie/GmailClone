package com.hfad.builderpattern.TutorialClasses;

public class Baguette extends Bread{
    @Override
    public String name() {
        return "Baguette";
    }

    @Override
    public int calories() {
        return 100;
    }
}
