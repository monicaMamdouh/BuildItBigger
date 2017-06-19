package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myandroidlib.LibActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.OnDataDeliver {

    private TextView mTextView;
    private Button mButton;
    private String Joke;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        mTextView=(TextView)root.findViewById(R.id.instructions_text_view);
        mButton=(Button)root.findViewById(R.id.instructions_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).tellJoke(root);
                Intent intent=new Intent(getActivity(), LibActivity.class);
                intent.putExtra("joke",Joke);
                startActivity(intent);

            }

        });
        //execute Asyntask
        EndpointsAsyncTask endpointsAsyncTask=new EndpointsAsyncTask(this);
        endpointsAsyncTask.execute();

        return root;
    }

    @Override
    public void onDataDeliver(String data) {
        Joke=data;
    }
}
