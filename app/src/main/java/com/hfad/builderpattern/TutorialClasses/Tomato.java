package com.hfad.builderpattern.TutorialClasses;

public class Tomato extends Filling{
    @Override
    public String name() {
        return "Tomato";
    }

    @Override
    public int calories() {
        return 120;
    }
}
