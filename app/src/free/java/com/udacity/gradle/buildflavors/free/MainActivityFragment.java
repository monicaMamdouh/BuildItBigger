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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.OnDataDeliver {

    private TextView mTextView;
    private Button mButton;
    private InterstitialAd mInterstitialAd;
    private String Joke;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //interstitial ads
        mInterstitialAd=new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        AdRequest adRequestInterstitial = new AdRequest.Builder()
                .addTestDevice(com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequestInterstitial);


    }

    @Override
    public void onStart() {
        super.onStart();
        AdRequest adRequestInterstitial = new AdRequest.Builder()
                .addTestDevice(com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequestInterstitial);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        mTextView=(TextView)root.findViewById(R.id.instructions_text_view);
        mButton=(Button)root.findViewById(R.id.instructions_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                }
                ((MainActivity)getActivity()).tellJoke(root);

            }

        });
        //execute Asyntask
        EndpointsAsyncTask endpointsAsyncTask=new EndpointsAsyncTask(this);
        endpointsAsyncTask.execute();

        //banner ads
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // mAdView.setAdListener(new myAdListener(getActivity()));
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        //interstitial ads

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Intent intent=new Intent(getActivity(), LibActivity.class);
                intent.putExtra("joke",Joke);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDataDeliver(String data) {
        Joke=data;
    }
}
