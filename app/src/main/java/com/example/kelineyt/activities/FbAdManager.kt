package com.example.kelineyt.activities

import android.content.Context
import android.widget.LinearLayout
import android.widget.Toast
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdListener
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd

class FbAdManager(val ctx: Context) {
    private companion object {
        lateinit var adInter: InterstitialAd
    }

    fun showBanner(layout: LinearLayout, adId: String, size: AdSize = AdSize.BANNER_HEIGHT_50) {
        val adView = AdView(ctx, adId, size)
        layout.addView(adView)
        val config = adView.buildLoadAdConfig().withAdListener(object : AdListener {
            override fun onError(p0: Ad?, p1: AdError?) {
                Toast.makeText(ctx,"Banner ${p1?.errorMessage}", Toast.LENGTH_SHORT).show()
            }

            override fun onAdLoaded(p0: Ad?) {
                Toast.makeText(ctx,"Banner Loaded",Toast.LENGTH_SHORT).show()
            }

            override fun onAdClicked(p0: Ad?) {
                Toast.makeText(ctx,"Banner Clicked",Toast.LENGTH_SHORT).show()
            }

            override fun onLoggingImpression(p0: Ad?) {
                TODO("Not yet implemented")
            }
        }).build()
        adView.loadAd(config)
    }

    }
