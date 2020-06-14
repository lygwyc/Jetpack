package com.example.demoviewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity {
    MyViewModel model;
    TextView    tv;
    Button      bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvNumber);
        bt1 = findViewById(R.id.btAdd1);
        bt2 = findViewById(R.id.btAdd2);
        model = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        updateTextView();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.number += 1;
                updateTextView();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.number += 2;
                updateTextView();
            }
        });
    }

    private void updateTextView() {
        tv.setText(String.valueOf(model.number));
    }
}