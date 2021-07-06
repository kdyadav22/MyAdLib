package com.tidee.ironservice;

import android.app.Activity;
import android.content.res.Resources;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MyInterAd {
    Activity activity;
    String adUnitId;
    private InterstitialAd mInterstitialAd;

    public MyInterAd(Activity activity, String adUnitId) {
        this.activity = activity;
        this.adUnitId = adUnitId;
        MobileAds.initialize(activity);
        initializeInterstitialAd(activity);
    }

    private void initializeInterstitialAd(Activity activity) {
        try {
            mInterstitialAd = new InterstitialAd(activity);
            mInterstitialAd.setAdUnitId(adUnitId);
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        } catch (Resources.NotFoundException e) {
            e.getMessage();
        }
    }

    public void showInterstitialAd() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

}
