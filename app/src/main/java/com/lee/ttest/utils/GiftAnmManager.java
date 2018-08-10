package com.lee.ttest.utils;

import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;


import com.lee.ttest.R;
import com.lee.ttest.bsrgift.BSRGiftLayout;
import com.lee.ttest.bsrgift.BSRGiftView;
import com.lee.ttest.bsrgift.BSRPathPoint;
import com.lee.ttest.bsrgift.BSRPathView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 * Created by yan on 2016/12/14.
 */

public class GiftAnmManager {

    private BSRGiftLayout giftLayout;
    private Context context;

    public GiftAnmManager(BSRGiftLayout giftLayout, Context context) {
        this.context = context;
        this.giftLayout = giftLayout;
    }

    public void showKiss() {
        final BSRGiftView bsrGiftView = new BSRGiftView(context);
        int during = 2000;
        bsrGiftView.setAlphaTrigger(0.99f);
        List<BSRPathPoint> bsrPathPoints = new ArrayList<>();

        BSRPathPoint pathPoint = new BSRPathPoint();
        pathPoint.setRes(context, R.drawable.kiss_chun);
        pathPoint.setDuring(during);
        pathPoint.setPositionInScreen(true);
        pathPoint.setPositionXPercent(0.5f);
        pathPoint.setPositionYPercent(0.5f);
        pathPoint.setPositionPoint(0.68f, 0.45f);
        pathPoint.addScaleControl(0.2f);
        pathPoint.addScaleControl(0.8f);
        pathPoint.addScaleControl(0.8f);
        pathPoint.addScaleControl(0.8f);
        pathPoint.addScaleControl(0.8f);
        pathPoint.addScaleControl(0.8f);
        pathPoint.addScaleControl(0.8f);
        pathPoint.setXPercent(0.5f);
        pathPoint.setYPercent(0.5f);
        pathPoint.setAdjustScaleInScreen(0.5f);
        pathPoint.setAntiAlias(true);
        bsrPathPoints.add(pathPoint);

        BSRPathPoint pathPointHeart1 = new BSRPathPoint();
        pathPointHeart1.setRes(context, R.drawable.kiss_xin);
        pathPointHeart1.setDuring(during);
        pathPointHeart1.setPositionInScreen(true);
        pathPointHeart1.setPositionXPercent(0.5f);
        pathPointHeart1.setPositionYPercent(0.5f);
        pathPointHeart1.setPositionPoint(0.3f, 0.45f);
        pathPointHeart1.addScaleControl(0.0f);
        pathPointHeart1.addScaleControl(0.0f);
        pathPointHeart1.addScaleControl(0.0f);
        pathPointHeart1.addScaleControl(0.0f);
        pathPointHeart1.addScaleControl(0.8f);
        pathPointHeart1.addScaleControl(0.8f);
        pathPointHeart1.addScaleControl(0.8f);
        pathPointHeart1.addScaleControl(0.8f);
        pathPointHeart1.setXPercent(0.5f);
        pathPointHeart1.setYPercent(0.5f);
        pathPointHeart1.setAdjustScaleInScreen(0.21f);
        pathPointHeart1.setAntiAlias(true);
        bsrPathPoints.add(pathPointHeart1);

        BSRPathPoint pathPointHeart2 = new BSRPathPoint();
        pathPointHeart2.setRes(context, R.drawable.kiss_xin);
        pathPointHeart2.setDuring(during);
        pathPointHeart2.setPositionInScreen(true);
        pathPointHeart2.setPositionXPercent(0.5f);
        pathPointHeart2.setPositionYPercent(0.5f);
        pathPointHeart2.setPositionPoint(0.22f, 0.45f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.0f);
        pathPointHeart2.addScaleControl(0.5f);
        pathPointHeart2.addScaleControl(0.5f);
        pathPointHeart2.setXPercent(0.5f);
        pathPointHeart2.setYPercent(0.5f);
        pathPointHeart2.setAdjustScaleInScreen(0.17f);
        pathPointHeart2.setAntiAlias(true);
        bsrPathPoints.add(pathPointHeart2);

        BSRPathView bsrPathView = new BSRPathView();
        bsrPathView.setChild(bsrGiftView);
        bsrPathView.setDuring(during * 2);

        giftLayout.addChild(bsrPathView);
        bsrGiftView.addBSRPathPoints(bsrPathPoints);
    }

}
