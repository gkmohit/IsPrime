package com.example.mapdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup.LayoutParams;

import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.StreetViewPanoramaView;
import com.google.android.gms.maps.model.LatLng;

/**
 * This shows how to create a simple activity with streetview
 */
public class StreetViewPanoramaViewDemoActivity extends FragmentActivity {

    // George St, Sydney
    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);

    private StreetViewPanoramaView mSvpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StreetViewPanoramaOptions options = new StreetViewPanoramaOptions();
        if (savedInstanceState == null) {
            options.position(SYDNEY);
        }

        mSvpView = new StreetViewPanoramaView(this, options);
        addContentView(mSvpView,
            new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

      mSvpView.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        mSvpView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mSvpView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mSvpView.onDestroy();
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mSvpView.onSaveInstanceState(outState);
    }
}
