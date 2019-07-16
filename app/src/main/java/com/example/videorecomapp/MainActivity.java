package com.example.videorecomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        add the button
        textView = findViewById(R.id.text_view);
        final Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                Log.d("debug", "button1, Perform action on click");
                String str = getString(R.string.bt0);
                textView.setText(str);
            }
        });
    }
}
