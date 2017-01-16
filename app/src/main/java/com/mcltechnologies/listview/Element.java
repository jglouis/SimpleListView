package com.mcltechnologies.listview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

/**
 * Created by JGLouis on 13/01/2017.
 */

public class Element {
    private String name;
    private String description;
    private int color;

    public Element(String name, String description, @ColorInt int color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getAvatar() {
        return new ColorDrawable(color);
    }

    @Override
    public String toString() {
        return name;
    }
}
