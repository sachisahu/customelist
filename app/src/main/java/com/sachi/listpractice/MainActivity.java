package com.sachi.listpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Devloper> devlopers = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        devlopers.add(new Devloper("Don","Dev"));
        devlopers.add(new Devloper("Sachi","UI"));
        devlopers.add(new Devloper("Pinu","Backend"));


        CustomListAdapter customListAdapter = new CustomListAdapter(this,devlopers);
        listView.setAdapter(customListAdapter);

    }

    public void Covid(View view) {
        Intent i = new Intent(MainActivity.this,ListOfStateAndCases.class);
        startActivity(i);


    }

    public class Devloper{
        String name;
        String degn;


        public Devloper(String name, String degn) {
            this.name = name;
            this.degn = degn;
        }
    }
}