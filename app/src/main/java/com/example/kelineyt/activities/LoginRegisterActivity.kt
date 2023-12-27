package com.example.kelineyt.activities

//import android.util.Log
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.kelineyt.R
//import com.facebook.ads.AdSize
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginRegisterActivity : AppCompatActivity() {

    //ads mob  lateinit
    private lateinit var mAdView : AdView
    private var mInterstitialAd: InterstitialAd? = null
    private lateinit var showInterstitialButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actitivty_login_register)

        //fb banner ads
        val ad = FbAdManager(this)
        ad.showBanner(findViewById(R.id.banner_wrapper),"IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID")



        //New line Added ads mob
        MobileAds.initialize(this) {}
        //Banner Ads
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //Interstitial Ads

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
              //  Log.d(TAG, adError?.toString())
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
             //   Log.d(TAG, 'Ad was loaded.')
                mInterstitialAd = interstitialAd
            }
        })
        showInterstitialButton = findViewById(R.id.showInterstitialButton)
        showInterstitialButton.setOnClickListener{
            //show the interstitial ads when click on button
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {
                //Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }
        }

            }
        }
