package com.example.wielomiany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Intent i = getIntent();
        Polynomial polynomial = (Polynomial) i.getSerializableExtra("polynomial");

        final TextView textView = (TextView) findViewById(R.id.tvResponse);

        String adres=polynomial.adress();

        String url = "https://newton.now.sh/api/v2/derive/"+adres;

        RequestQueue queue = Volley.newRequestQueue(this);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {

            Derevative derevative  = gson.fromJson(response, Derevative.class);
            textView.setText(derevative.getResult());


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work");
            }
        }

        );

        queue.add(stringRequest);

    }
}