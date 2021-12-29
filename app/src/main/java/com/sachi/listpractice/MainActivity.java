package com.sachi.listpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Devloper> devlopers = new ArrayList<>();
    ListView listViewUser;
    FloatingActionButton btnAdd;
    CustomListAdapter customListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewUser=findViewById(R.id.listViewUser);
        btnAdd = findViewById(R.id.addUser);
        customListAdapter = new CustomListAdapter(this,devlopers);

        devlopers.add(new Devloper("Don","Dev"));
        devlopers.add(new Devloper("Sachi","UI"));
        devlopers.add(new Devloper("Pinu","Backend"));


        CustomListAdapter customListAdapter = new CustomListAdapter(this,devlopers);
        listViewUser.setAdapter(customListAdapter);



    }


    public void Covid(View view) {
        Intent i = new Intent(MainActivity.this,ListOfStateAndCases.class);
        startActivity(i);


    }

    public void addUser(View view) {
        Intent i = new Intent(MainActivity.this,addUser.class);
        i.putExtra("btnName","Save");
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!= null){
            String strname = data.getStringExtra("devName");
            String strposition = data.getStringExtra("devPosition");
            Devloper newDev = new Devloper(strname,strposition);
            devlopers.add(newDev);
            customListAdapter.notifyDataSetChanged();
            Log.d("DataAdd",strname+""+strposition+"  Adding  + " + devlopers.add(newDev));
        }

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