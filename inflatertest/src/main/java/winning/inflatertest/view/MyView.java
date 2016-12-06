package winning.inflatertest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jiang on 2016/12/6.
 * 自定义View绘制文字
 */

public class MyView extends View {
    private Paint mPaint;
    public MyView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
        mPaint.setColor(Color.BLUE);
        String text = "HEllo";
        canvas.drawText(text,0,getHeight()/2,mPaint);
    }
}
