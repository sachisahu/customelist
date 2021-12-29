package com.sachi.listpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    ArrayList<MainActivity.Devloper> devlopers;
    String[]  name,pos1;
    Activity context;

    public CustomListAdapter(@NonNull Activity context, ArrayList<MainActivity.Devloper> devlopers) {
        super(context, R.layout.customelistview,devlopers);
        this.context = context;
        this.devlopers = devlopers;
    }
    TextView txtname;
    TextView txtdegn;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        MainActivity.Devloper devloper = (MainActivity.Devloper) getItem(position);
        View rowview = layoutInflater.inflate(R.layout.customelistview , null,true);
        txtname = rowview.findViewById(R.id.txtName);
        txtdegn = rowview.findViewById(R.id.txtDegn);

        rowview.findViewById(R.id.deleteUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                devlopers.remove(position);
                notifyDataSetChanged();
            }
        });

        rowview.findViewById(R.id.editUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,addUser.class);
                i.putExtra("nameDev",devloper.name);
                i.putExtra("posDev",devloper.degn);
                i.putExtra("btnName","Update");
                context.startActivity(i);

            }
        });



        txtname.setText(devloper.name);
        Log.d("devname",devloper.name);
        txtdegn.setText(devloper.degn);
        return  rowview;
    }
}
