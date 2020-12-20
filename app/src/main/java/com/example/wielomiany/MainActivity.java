package com.example.wielomiany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleRequestClick(View view) {

        TextView textView= (TextView) findViewById(R.id.inPoly);
        Polynomial polynomial = new Polynomial(textView.getText().toString());

        Intent intent = new Intent(this, ActivityA.class);

        intent.putExtra("polynomial", polynomial);
        startActivity(intent);

    }

    public void jsonRequestClick(View view) {

        TextView textView= (TextView) findViewById(R.id.inPoly);
        Polynomial polynomial = new Polynomial(textView.getText().toString());

        Intent intent = new Intent(this, ActivityB.class);

        intent.putExtra("polynomial", polynomial);
        startActivity(intent);

    }
}