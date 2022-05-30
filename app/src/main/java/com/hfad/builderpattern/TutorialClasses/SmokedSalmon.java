package com.hfad.builderpattern.TutorialClasses;

public class SmokedSalmon extends Filling{
    @Override
    public String name() {
        return "Smoked salmon";
    }

    @Override
    public int calories() {
        return 400;
    }
}
