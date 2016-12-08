package winning.inflatertest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jiang on 2016/12/7.
 * 自定义计数器
 */

public class CounterView extends View implements View.OnClickListener {
    private Paint mPaint;
    private Rect mBounds;
    private int mCount = 0;

    private void initViews() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();

        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //首先来画一个矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        //下面来画文字
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(35);
        String text = String.valueOf(mCount);
        mPaint.getTextBounds(text, 0, text.length(), mBounds);
        int textWidth = mBounds.width();
        int textHeight = mBounds.height();
        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 2, mPaint);

    }

    public CounterView(Context context) {
        super(context);
        initViews();
    }

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public CounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CounterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
    }

    @Override
    public void onClick(View view) {
        mCount++;
        invalidate();
    }
}
