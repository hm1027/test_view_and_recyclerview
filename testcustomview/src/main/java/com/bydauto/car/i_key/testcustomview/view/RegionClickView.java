package com.bydauto.car.i_key.testcustomview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * author：hm2359767 on 16/12/19 14:55
 * mail：huang.min12@byd.com
 * tele: 18666287409
 */
public class RegionClickView extends View {
    private Path mPath;
    private Region mCircleRegion;
    private Paint mPaint;
    private RectF rectF;
    private static final int Custom_Color = 0xFF4E5268;
    private static final String TAG = "RegionClickView";

    public RegionClickView(Context context) {
        this(context, null);
    }

    public RegionClickView(Context context, AttributeSet attr) {
        super(context, attr);
        mPath = new Path();
        mCircleRegion = new Region();
        mPaint = new Paint();
        mPaint.setColor(Custom_Color);
        mPaint.setStyle(Paint.Style.FILL);
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "w = " + w + " , " + "h = " + h);
        mPath.addCircle(w / 2, h / 2, 300, Path.Direction.CW);
        rectF = new RectF(-w, -h, w, h);
        Region globleCircle = new Region(-w, -h, w, h);
        mCircleRegion.setPath(mPath, globleCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "X = " + event.getX() + " , " + "Y = " + event.getY());
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (mCircleRegion.contains(x, y)) {
                    Toast.makeText(this.getContext(), "circle is clicked", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path circle = mPath;
        canvas.drawPath(circle, mPaint);
//        canvas.drawRect(rectF, mPaint);
    }
}
