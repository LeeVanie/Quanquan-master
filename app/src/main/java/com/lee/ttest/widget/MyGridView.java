package com.lee.ttest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import com.lee.ttest.R;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class MyGridView extends GridView {
    
    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    /**
     * 重绘分割线
     */

//    @Override
//    protected void dispatchDraw(Canvas canvas) {
//        // TODO Auto-generated method stub
//        super.dispatchDraw(canvas);
//
//        View localView1 = getChildAt(0);
//        int column = getWidth() / localView1.getWidth();
//        int childCount = getChildCount();
//        Paint localPaint;
//        localPaint = new Paint();
//        localPaint.setStyle(Paint.Style.STROKE);
//        localPaint.setStrokeWidth(2);
//        localPaint.setColor(getContext().getResources().getColor(R.color.gray01));
//        for(int i = 0;i < childCount;i++){
//            View cellView = getChildAt(i);
//            if((i + 1) % column == 0){
//                if (i != childCount -1){
//                    canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), localPaint);
//                }
//            }else if((i + 1) > (childCount - (childCount % column))){
//                canvas.drawLine(cellView.getRight(), cellView.getTop(), cellView.getRight(), cellView.getBottom(), localPaint);
//            }else{
//                canvas.drawLine(cellView.getRight(), cellView.getTop(), cellView.getRight(), cellView.getBottom(), localPaint);
//                if (i != childCount -2 && i != childCount -3){
//                    canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), localPaint);
//                }
//            }
//        }
//        if(childCount % column != 0){
//            for(int j = 0 ;j < (column-childCount % column) ; j++){
//                View lastView = getChildAt(childCount - 1);
//                canvas.drawLine(lastView.getRight() + lastView.getWidth() * j, lastView.getTop(), lastView.getRight() + lastView.getWidth()* j, lastView.getBottom(), localPaint);
//            }
//        }
//    }
}
//jhfghfh