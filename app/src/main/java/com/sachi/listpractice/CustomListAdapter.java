package com.sachi.listpractice;

import android.app.Activity;
import android.content.Context;
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



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        MainActivity.Devloper devloper = (MainActivity.Devloper) getItem(position);
        View rowview = layoutInflater.inflate(R.layout.customelistview , null,true);
        TextView txtname = rowview.findViewById(R.id.txtName);
        TextView txtdegn = rowview.findViewById(R.id.txtDegn);



        txtname.setText(devloper.name);
        txtdegn.setText(devloper.degn);
        return  rowview;
    }
}
