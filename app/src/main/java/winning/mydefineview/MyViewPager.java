package winning.mydefineview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Jiang on 2016/12/6.
 */

public class MyViewPager extends ViewPager {
    private int lastX;
    private int lastY;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int dealtX = 0;
        int dealtY = 0;

        int x = (int) ev.getRawX();
        int y = (int) ev.getRawY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dealtX = 0;
                dealtY = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                dealtX += Math.abs(lastX - x);
                dealtY += Math.abs(lastY - y);
                if (dealtX >= dealtY) {
                    requestDisallowInterceptTouchEvent(true);
                } else {
                    requestDisallowInterceptTouchEvent(false);
                }

                lastX = x;
                lastX = y;

                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
