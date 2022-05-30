package com.hfad.builderpattern.TutorialClasses;

public class Bagel extends Bread{
    @Override
    public String name() {
        return "Bagel";
    }

    @Override
    public int calories() {
        return 250;
    }
}
