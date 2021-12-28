package com.sachi.listpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListOfStateAndCases extends AppCompatActivity {

    ListView listView;
    ArrayList<ResponseClass> responseClasses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_state_and_cases);
        listView = findViewById(R.id.listViewCovid);
        fetchCovidData();
        //responseClasses.add(new ResponseClass("OR",3434));


        CustomListStatesAdapter customListStatesAdapter = new CustomListStatesAdapter(this,responseClasses);
        listView.setAdapter(customListStatesAdapter);
    }

    private void fetchCovidData() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("https://covidtracking.com/api/states")
                .method("GET",null).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("Api Faliure",e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String data = response.body().string();
                Gson gson = new Gson();
                ResponseClass[] responseClasses = gson.fromJson(data,ResponseClass[].class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        /*TextView txtState = findViewById(R.id.txtSachi2);
                        for(int i=0;i<responseClasses.length;i++){
                            //txtState.setText(txtState.getText() + responseClasses[i].state+"\n");
                        }*/

                    }
                });
            }
        });
    }

    public class ResponseClass{
        public String state;
        public int positive;

        public ResponseClass(String state, int positive) {
            this.state = state;
            this.positive = positive;
        }
    }
}