package com.lee.ttest.base;

import com.lee.ttest.widget.SwipeListLayout;

import java.util.HashSet;
import java.util.Set;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class MyOnSlipStatusListener implements SwipeListLayout.OnSwipeStatusListener {

    private Set<SwipeListLayout> sets = new HashSet();
    private SwipeListLayout slipListLayout;

    public MyOnSlipStatusListener(SwipeListLayout slipListLayout) {
        this.slipListLayout = slipListLayout;
    }

    @Override
    public void onStatusChanged(SwipeListLayout.Status status) {
        if (status == SwipeListLayout.Status.Open) {
            //若有其他的item的状态为Open，则Close，然后移除
//            if (sets.size() > 0) {
//                for (SwipeListLayout s : sets) {
//                    s.setStatus(SwipeListLayout.Status.Close, true);
//                    sets.remove(s);
//                }
//            }
//            sets.add(slipListLayout);
//        } else {
//            if (sets.contains(slipListLayout))
//                sets.remove(slipListLayout);
        }
    }

    @Override
    public void onStartCloseAnimation() {

    }

    @Override
    public void onStartOpenAnimation() {

    }

} 
//jhfghfh