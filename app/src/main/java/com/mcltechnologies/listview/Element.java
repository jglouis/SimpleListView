package com.mcltechnologies.listview;

/**
 * Created by JGLouis on 13/01/2017.
 */

public class Element {
    private String name;
    private String description;

    public Element(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
