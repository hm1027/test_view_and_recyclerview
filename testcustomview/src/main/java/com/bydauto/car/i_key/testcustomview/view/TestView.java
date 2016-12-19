package com.bydauto.car.i_key.testcustomview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bydauto.car.i_key.testcustomview.R;

/**
 * author：hm2359767 on 16/12/16 08:05
 * mail：huang.min12@byd.com
 * tele: 18666287409
 */
public class TestView extends View {
    private Paint mPaint;
    private Paint mPaintText;
    private int mWidth;
    private int mHeight;
    private PointF start, end, control;
    private Bitmap mBitmap;
    private Matrix mPolyMatrix;
    private Matrix mInvertMatrix;
    private static final String TAG = "TESTVIEW";

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public TestView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        initPaint(Color.BLACK, Paint.Style.STROKE, 5f);
        mPaintText = new Paint();
        mPaintText.setColor(Color.RED);
        mPaintText.setStyle(Paint.Style.STROKE);
        mPaintText.setTextSize(50f);
        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control = new PointF(0, 0);
        initPolyMatrixAndBitmap();
    }

    public void initPaint(int color, Paint.Style style, float width) {
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setStyle(style);
        mPaint.setStrokeWidth(width);
        mPaint.setTextSize(60f);
    }

    private void initPolyMatrixAndBitmap() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_bitmap);

        mPolyMatrix = new Matrix();

        float[] src = new float[]{0, 0, mBitmap.getWidth(), 0, mBitmap.getWidth(), mBitmap
                .getHeight(),
                0, mBitmap.getHeight()};

        float[] dst = new float[]{0, 0, mBitmap.getWidth(), 40, mBitmap.getWidth(), mBitmap
                .getHeight()
                - 20, 0, mBitmap.getHeight()};
        mPolyMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
        mPolyMatrix.postTranslate(0, 200);
    }

    //确定view大小
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;

        //初始化数据点
        start.x = mWidth / 2 - 200;
        start.y = mHeight / 2;
        end.x = mWidth / 2 + 200;
        end.y = mHeight / 2;
        //初始化控制点位置
        control.x = mWidth / 2;
        control.y = mHeight / 2 - 100;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        //根据触摸位置更新控制点，并提示重绘
//        control.x = event.getX();
//        control.y = event.getY();
//        invalidate();
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        //绘制一个点
//        canvas.drawPoint(100, 100, mPaint);
//        //绘制一组点
//        canvas.drawPoints(new float[]{
//                500, 500, 500, 600, 500, 700
//        }, mPaint);
//        // 绘制直线
//        canvas.drawLine(300,300,500,500,mPaint);
//        //绘制多条直线
//        canvas.drawLines(new float[]{
//                100,100,200,200,100,200,200,300
//        },mPaint);
//
//        RectF rect = new RectF(100, 100, 400, 400);
//        canvas.drawRect(rect, mPaint); //绘制矩形
//        canvas.drawRoundRect(rect, 30, 30, mPaint);//绘制圆角矩形
//        canvas.drawOval(rect, mPaint);//绘制椭圆
//        canvas.drawCircle(500, 500, 400, mPaint);//绘制圆心（500，500）半径400的圆
        //绘制圆弧
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(rect, mPaint);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawArc(rect, 0, 90, true, mPaint);
//        mPaint.setColor(Color.GREEN);
//        canvas.drawArc(rect, 45, 90,true, mPaint);
        //坐标系移动
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(100, 100);
//        canvas.drawCircle(0, 0, 40, mPaint);
//        mPaint.setColor(Color.GREEN);
//        canvas.translate(100, 100);//坐标移动是相对上一次移动后的原点并不是以（0，0）
//        canvas.drawCircle(0, 0, 40, mPaint);
//        canvas.translate(mWidth / 2, mHeight / 2);
//        //绘制坐标系
//        mPaint.setColor(Color.RED);
//        canvas.drawLines(new float[]{
//                -mWidth, 0, mWidth, 0, 0, -mHeight, 0, mHeight
//        }, mPaint);

//        RectF rect = new RectF(0, -400, 400, 0);

//        for (int i = 0; i <= 10; i++) {
//            canvas.drawRect(rect, mPaint);
//            canvas.scale(0.9f, 0.9f);
//        }
//        canvas.scale(0.5f, 0.5f);//以坐标系原点为中心缩放坐标轴
//        canvas.scale(-0.5f, -0.5f, 100, 0);//以（100，0）为中心缩放坐标轴
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rect, mPaint);
//        canvas.scale(-0.5f, -0.5f, 100, 0);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(rect, mPaint);

//        canvas.rotate(90);//旋转画布
//        mPaint.setColor(Color.GREEN);
//        canvas.drawRect(rect, mPaint);
//        canvas.drawCircle(0, 0, 400, mPaint);
//        canvas.drawCircle(0, 0, 380, mPaint);
//        for (int i = 0; i <= 360; i+=10) {
//            canvas.drawLine(0, -380, 0, -400, mPaint);
//            canvas.rotate(10);
//        }
//        String str = "ABCDEFG";
//
////        canvas.drawText(str,100,200,mPaintText);//绘制文本
//        canvas.drawText(str, 1, 3, 100, 200, mPaintText);//截取文本[1,3)字符

//        mPaint.setColor(Color.BLACK);
//        Path path = new Path();
//        path.lineTo(200, 200);//path路径至参数处，path默认起点为原点
//        path.moveTo(200, 100);//设置下一次操作的起点，不影响前一次的操作
//        path.setLastPoint(200, 100);//设置下一次操作的起点，影响前次操作
//        path.lineTo(200, 0);
//        path.close();//使路径闭合
//        path.addRect(-200,-200,200,200,Path.Direction.CW); //添加一个矩形路径
//        path.setLastPoint(-300,300);
        //路径中加入圆弧
//        path.lineTo(100,100);
//        RectF oval = new RectF(0,0,300,300);
//        path.addArc(oval,0,270);
//        path.arcTo(oval,0,270,true);

//        path.lineTo(0, 400);
//        path.lineTo(400, 400);
//        path.lineTo(400, 0);
//        path.lineTo(0, 0);
//
//        RectF rect = new RectF();
//        path.isRect(rect);//判断路径是否为矩形
//        Logger.i("is rect?" + path.isRect(rect) + " left is " + rect.left + " top is " + rect
// .top +
//                " " +
//                "right is " +
//                rect
//                        .right +
//                " bottom" +
//                " is "
//                + rect
//                .bottom);
//        //绘制数据点和控制点
//        mPaint.setColor(Color.GRAY);
//        mPaint.setStrokeWidth(20f);
//        canvas.drawPoint(start.x, start.y, mPaint);
//        canvas.drawPoint(end.x, end.y, mPaint);
//        canvas.drawPoint(control.x, control.y, mPaint);
//        //绘制辅助线
//        mPaint.setColor(Color.BLACK);
//        mPaint.setStrokeWidth(4f);
//        canvas.drawLine(start.x, start.y, control.x, control.y, mPaint);
//        canvas.drawLine(end.x, end.y, control.x, control.y, mPaint);
//        //绘制二阶曲线贝塞尔路径
//        mPaint.setColor(Color.RED);
//        mPaint.setStrokeWidth(8f);
//        canvas.translate(mWidth / 2, mHeight / 2);//平移坐标系
//        Path path = new Path();
//        Path path1 = new Path();
//        Path path2 = new Path();
//        Path path3 = new Path();
//        Path path4 = new Path();
//        //画太极鱼
//        path1.addCircle(0, 0, 200, Path.Direction.CW);
//        canvas.drawPath(path1, mPaint);
//        path2.addRect(0, -200, 200, 200, Path.Direction.CW);
//        mPaint.setColor(Color.GREEN);
//        canvas.drawPath(path2, mPaint);
//        path3.addCircle(0, -100, 100, Path.Direction.CW);
//        mPaint.setColor(Color.RED);
//        canvas.drawPath(path3, mPaint);
//        path4.addCircle(0, 100, 100, Path.Direction.CW);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawPath(path4, mPaint);
//        path.moveTo(start.x,start.y);
//        path.quadTo(control.x, control.y, end.x, end.y);
//        path1.op(path2, Path.Op.DIFFERENCE);//path1=path1-path2
//        path1.op(path3, Path.Op.UNION);//path1=path1+path3
//        path1.op(path4, Path.Op.DIFFERENCE);//path1=path1-path4
//        canvas.drawPath(path1, mPaint);
        canvas.drawBitmap(mBitmap, mPolyMatrix, null);

    }
}
