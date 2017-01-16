package com.mcltechnologies.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Element> elements = new ArrayList<>();
        elements.add(new Element("Alice", "admin"));
        elements.add(new Element("Bob", "admin"));
        elements.add(new Element("Christophe", "admin"));

        ListView listView = (ListView)findViewById(R.id.list_view);
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elements);
        listView.setAdapter(listAdapter);
    }
}
