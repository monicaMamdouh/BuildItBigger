package com.udacity.gradle.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.MyClass;

public class MainActivity extends AppCompatActivity {

    private MyClass joker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }




    public void tellJoke(View view) {
        joker=new MyClass();
        Toast.makeText(this,joker.getJoke(), Toast.LENGTH_SHORT).show();
    }

}