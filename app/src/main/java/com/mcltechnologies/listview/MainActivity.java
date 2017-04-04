package com.mcltechnologies.listview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Element> elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            for (int i = 0; i <= 2000; i++) {
                elements.add(new Element("Alice", "admin", Color.RED));
                elements.add(new Element("Bob", "admin", Color.BLUE));
                elements.add(new Element("Christophe", "admin", Color.GREEN));
            }
        } else {
            elements = (List<Element>) savedInstanceState.getSerializable("elements");
        }

        ListView listView = (ListView) findViewById(R.id.list_view);
        ListAdapter listAdapter = new ElementAdapter(this, elements);
        listView.setAdapter(listAdapter);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        outState.putSerializable("elements", (Serializable) elements);
    }
}
