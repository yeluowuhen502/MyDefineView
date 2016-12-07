package winning.mydefineview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Jiang on 2016/12/6.
 */

public class MyVpVp extends ViewPager {
    public MyVpVp(Context context) {
        super(context);
    }

    public MyVpVp(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int count = 0;
        int currentPosition = 0;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                count = getAdapter().getCount();
                currentPosition = getCurrentItem();
                Log.d("position", currentPosition + "");
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                if (currentPosition == count - 1 || currentPosition == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
