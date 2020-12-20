package com.example.wielomiany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    public void onClick(View view) {

        TextView textView= (TextView) findViewById(R.id.inX);

        Intent i = getIntent();
        Polynomial polynomial = (Polynomial) i.getSerializableExtra("polynomial");

        double x= Double.parseDouble(textView.getText().toString());

        TextView result = (TextView) findViewById(R.id.tvResponse);
        result.setText(String.valueOf(polynomial.calculate(x)));
    }
}