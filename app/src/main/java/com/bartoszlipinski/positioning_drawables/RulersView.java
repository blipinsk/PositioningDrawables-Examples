package com.bartoszlipinski.positioning_drawables;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Bartosz Lipinski
 * 18.03.2016
 */
public class RulersView extends View {

    private int rulerWeight;
    private int firstRulerDistance;
    private int secondRulerDistance;

    private Paint rulerPaint;

    public RulersView(Context context) {
        super(context);
        setupView(context);
    }

    public RulersView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView(context);
    }

    public RulersView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupView(context);
    }

    private void setupView(Context context) {
        //EC008C
        setWillNotDraw(false);
        rulerWeight = context.getResources().getDimensionPixelSize(R.dimen.ruler_weight);
        firstRulerDistance = (int) (context.getResources().getDimensionPixelSize(R.dimen.size_s)
                + rulerWeight / 2f);
        secondRulerDistance = (int) (context.getResources().getDimensionPixelSize(R.dimen.keyline)
                +  rulerWeight / 2f);
        rulerPaint = new Paint();
        rulerPaint.setColor(ContextCompat.getColor(context, R.color.magenta));
        rulerPaint.setStrokeWidth(rulerWeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(firstRulerDistance, 0);
        canvas.drawLine(0, 0, 0, canvas.getHeight(), rulerPaint);
        canvas.restore();
        canvas.translate(secondRulerDistance, 0);
        canvas.drawLine(0, 0, 0, canvas.getHeight(), rulerPaint);
    }
}
