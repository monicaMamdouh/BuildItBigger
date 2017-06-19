package com.example.myandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LibActivity extends AppCompatActivity {

    private String Joke;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
        mTextView=(TextView)findViewById(R.id.joke_text_view);

        Joke=getIntent().getStringExtra("joke");
        mTextView.setText(Joke);


    }
}
