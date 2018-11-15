package com.news.mobilephone.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.news.mobilephone.R;
import com.news.mobilephone.utils.CommonUtils;

public class MyNewsProgress extends View {
    private int roundColor; //圆形进度条的颜色
    private int roundProgressColor;//圆形进度条进度的颜色
    private float roundWidth; //圆的宽度
    private float progress = 0; //当前进度
    private Paint mPaint; //画笔
    private int startAngle = -90; //起始位置
    private Context mContext;
    private long mCurrentPlayTime; //动画当前执行的时间

    private long mDuration;
    private long STEP = 5 * 1000l;  //步长时长
    private float STEPFLOAT = 5 * 1000f;  //步长时长
    private float stepProgress = 0; // 步长角度

    private ValueAnimator mValueAnimator;

    public MyNewsProgress(Context context) {
        super(context);
        init(context);
    }

    public MyNewsProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyNewsProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setStep(long step){
        STEP = step;
        STEPFLOAT = step;
    }


    private void init(Context context) {
        this.mContext = context;
        //初始化一只笔
        mPaint = new Paint();
        //获取xml当中设置的属性，如果没有设置，则设置一个默认值
        roundColor = Color.parseColor("#FCD13F");//#B72123
        roundProgressColor = context.getResources().getColor(R.color.colorWhite);//themeYellow 原颜色
        roundWidth = CommonUtils.dip2px(context, 3);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        //画背景圆环
        int center = getWidth() / 2;
        //设置半径
        float radius = (float) (center - roundWidth / 2);
        //设置圆圈的颜色
        mPaint.setColor(roundColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(roundWidth);//圆环的宽度
        mPaint.setAntiAlias(true);//设置抗锯齿

        //画外圈
        canvas.drawCircle(center, center, radius, mPaint);
        //画圆弧
        int nums = CommonUtils.dip2px(mContext, 3);
        RectF oval = new RectF(center - (radius - nums), center - (radius - nums), center + (radius - nums), center + (radius - nums));
//        oval.offset(3, 2);//使rectf_head所确定的矩形向右偏移100像素，向下偏移20像素
        mPaint.setColor(roundProgressColor);
        mPaint.setStrokeWidth(roundWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        //设置笔帽
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //话进度
        canvas.drawArc(oval, startAngle, progress, false, mPaint);

    }

    /**
     * 暂停后获取进度
     */
    public void stopProgress() {
        animStop();
    }

    /**
     * 设置总时长
     */
    public void setDuration(long mDuration) {
        if (STEP > mDuration) {
            throw new RuntimeException("步长要小于总是长");
        }
        this.mDuration = mDuration;

        //计算步长角度
        stepProgress = STEPFLOAT / mDuration * 360f;
    }


    private void initAnim() {
        mValueAnimator = ValueAnimator.ofFloat(progress, progress + stepProgress);
        mValueAnimator.setIntValues();
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progress = (float) animation.getAnimatedValue();
                mCurrentPlayTime = mValueAnimator.getCurrentPlayTime();
                if (progress >= 360f) {
                    progress = 0;
                    postInvalidate();
                    stopProgress();
                    if (onVideoProgressLisenter != null) {
                        onVideoProgressLisenter.end();
                    }
                } else {
                    postInvalidate();
                }
            }
        });

        mValueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                //mValueAnimator.setIntValues(progress, 360);
            }

        });
        //设置匀速插值器
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.setDuration(STEP);
    }

    public void animStart(long mDuration) {
        animStop();
        if(mDuration <= 0){
            throw new RuntimeException("总时长不能小于0");
        }
        setDuration(mDuration);
        initAnim();
        mValueAnimator.start();
    }

    public void setProgress(float progress) {
        if (progress < 0) {
            return;
        }
        stopProgress();
        this.progress = progress;
        postInvalidate();
    }


    public boolean getAnimatorStatus() {
        return mValueAnimator.isRunning();
    }

    private void animStop() {
        if(mValueAnimator != null) {
            mValueAnimator.cancel();
        }
    }

    public interface OnNewsProgressLisenter {
        void end();
    }

    private OnNewsProgressLisenter onVideoProgressLisenter;

    public void setOnNewsProgressLisenter(OnNewsProgressLisenter o) {
        if (this.onVideoProgressLisenter == null)
            this.onVideoProgressLisenter = o;
    }

    public float getProgressCurrent() {
        stopProgress();
        return progress;
    }

}
