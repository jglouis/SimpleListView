package com.mcltechnologies.listview;

import android.support.annotation.ColorInt;


class Element {
    private String name;
    private String description;
    @ColorInt
    private int color;
    private boolean selected = false;

    Element(String name, String description, @ColorInt int color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    @ColorInt
    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
