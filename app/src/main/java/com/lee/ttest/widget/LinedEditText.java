package com.lee.ttest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.lee.ttest.R;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class LinedEditText extends EditText {

    Paint paint;

    public LinedEditText(Context context) {
        super(context);
        init();
    }

    public LinedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float startX = getPaddingLeft();//开始位置
        float stopX = getWidth() - getPaddingRight();//结束位置
        float offsetY = getPaddingTop() - getPaint().getFontMetrics().top + paint.getStrokeWidth() * 2;//行间距
        for (int i = 0; i < getLineCount(); ++i) {
            float y = offsetY + getLineHeight() * i;
            canvas.drawLine(startX, y, stopX, y, paint);
        }

        super.onDraw(canvas);
    }

    private void init() {
        this.paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.orange01));
        paint.setStrokeWidth(getLineHeight() / 10);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }
}
//jhfghfh