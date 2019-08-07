package com.example.josycom.counterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.count_score);

        //Checks if the last state of the App was saved before reconfiguration
        //And displays the saved content on the TextView
        if (savedInstanceState != null){
            boolean isNotEmpty = savedInstanceState.getBoolean("not_empty");
            if (isNotEmpty){
                textView.setText(Integer.toString(savedInstanceState.getInt("score")));
                score = savedInstanceState.getInt("score");
            }
        }
    }

    public void countUp(View view) {
        score++;
        textView.setText(Integer.toString(score));
    }

    // Checks if there is any content of the current state to be saved and saves the state
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!textView.getText().toString().isEmpty()){
            outState.putBoolean("not_empty", true);
            outState.putInt("score", Integer.parseInt(textView.getText().toString()));
        }
    }
}
