package com.swooby.app.swooby;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION_CODES;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class CircleFooView
        extends View
{
    //private int mDashLength   = 11;
    //private int mDashWidth    = 4;
    //private int mDashDuration = 1000;
    private int mOuterColor = Color.DKGRAY;

    private Paint mOuterPaint;
    private Path  mOuterPath;

    public CircleFooView(Context context)
    {
        super(context);
        initialize(context, null);
    }

    public CircleFooView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initialize(context, attrs);
    }

    public CircleFooView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    public CircleFooView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs)
    {
        /*
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RippleBackground);
        try
        {
            if (ta != null)
            {
                rippleColor = ta.getColor(R.styleable.RippleBackground_rippleColor, rippleColor);
                rippleStrokeWidth = ta.getDimension(R.styleable.RippleBackground_rippleStrokeWidth, rippleStrokeWidth);
                rippleRadius = ta.getDimension(R.styleable.RippleBackground_rippleRadius, rippleRadius);
                rippleDurationTime = ta.getInt(R.styleable.RippleBackground_rippleDuration, rippleDurationTime);
                rippleAmount = ta.getInt(R.styleable.RippleBackground_rippleAmount, rippleAmount);
                rippleScale = ta.getFloat(R.styleable.RippleBackground_rippleScale, rippleScale);
                rippleType = ta.getInt(R.styleable.RippleBackground_rippleType, rippleType);
            }
        }
        finally
        {
            if (ta != null)
            {
                ta.recycle();
            }
        }
        */

        mOuterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mOuterPaint.setStyle(Style.FILL);
        mOuterPaint.setColor(mOuterColor);
        //mDashPaint.setPathEffect(new DashPathEffect(new float[] { mDashLength, mDashLength }, 0));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);

        float padding = 0;//(float) Math.ceil(mDashWidth / 2f);

        mOuterPath = new Path();
        mOuterPath.addOval(new RectF(padding, padding, w - padding, h - padding), Direction.CCW);
        mOuterPath.close();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawPath(mOuterPath, mOuterPaint);
    }
}
