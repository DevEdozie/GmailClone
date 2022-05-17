package com.hfad.builderpattern;

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
