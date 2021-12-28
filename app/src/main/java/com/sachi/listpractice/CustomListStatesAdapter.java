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

public class CustomListStatesAdapter extends ArrayAdapter {

    ArrayList<ListOfStateAndCases.ResponseClass> covidResponse;
    Activity context;


    public CustomListStatesAdapter(@NonNull Activity context, ArrayList<ListOfStateAndCases.ResponseClass> covidResponse) {
        super(context, R.layout.customeliststate,covidResponse);
        this.context = context;
        this.covidResponse = covidResponse;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        ListOfStateAndCases.ResponseClass responseClass = (ListOfStateAndCases.ResponseClass) getItem(position);
        View rowView = layoutInflater.inflate(R.layout.customeliststate,null,true);
        TextView txtState = rowView.findViewById(R.id.txtState);
        TextView txtPositive = rowView.findViewById(R.id.txtCases);

        String str = responseClass.state+ " and " +responseClass.positive ;

        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
        txtState.setText(responseClass.state);
        txtPositive.setText(responseClass.positive);
        return rowView;
    }
}
