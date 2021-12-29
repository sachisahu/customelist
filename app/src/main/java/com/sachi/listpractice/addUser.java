package com.sachi.listpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addUser extends AppCompatActivity {

    EditText name,position;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_user);
        name = findViewById(R.id.txtAddName);
        position = findViewById(R.id.txtAddPosition);
        save = findViewById(R.id.btnAddButton);
        save.setText("Save");
        Intent i = getIntent();
        String strName = i.getStringExtra("nameDev");
        String strPos = i.getStringExtra("posDev");

        name.setText(strName);
        position.setText(strPos);
        save.setText(i.getStringExtra("btnName"));
    }


    public void addUser(View view) {
        Intent i = new Intent();
        i.putExtra("devName",name.getText().toString());
        i.putExtra("devPosition",position.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}