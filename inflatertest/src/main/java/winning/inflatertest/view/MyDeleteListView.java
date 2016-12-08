package winning.inflatertest.view;

import android.content.Context;
import android.gesture.GestureOverlayView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import winning.inflatertest.R;

/**
 * Created by Jiang on 2016/12/8.
 */

public class MyDeleteListView extends ListView implements View.OnTouchListener, GestureDetector.OnGestureListener {
    private OnDeleteListener listener;
    private GestureDetector gestureDetector;

    private View deleteButton;

    private ViewGroup itemLayout;

    private int selectedItem;


    private boolean isDeleteShown;

    public MyDeleteListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    public interface OnDeleteListener {
        void onDelete(int index);
    }

    public void setOnDeleteListener(OnDeleteListener listener) {
        this.listener = listener;
    }

    //OnGestureDecetor
    @Override
    public boolean onDown(MotionEvent event) {
        if (!isDeleteShown) {
            //得到当前条目的位置
            selectedItem = pointToPosition((int) event.getX(), (int) event.getY());
        }
        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent event, MotionEvent event1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {

    }

    @Override
    public boolean onFling(MotionEvent event, MotionEvent event1, float v, float v1) {
        if (!isDeleteShown && Math.abs(v) > Math.abs(v1)) {
            deleteButton = LayoutInflater.from(getContext()).inflate(R.layout.delete_layout, null);
            deleteButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemLayout.removeView(deleteButton);
                    deleteButton = null;
                    isDeleteShown = false;
                    listener.onDelete(selectedItem);
                }
            });
            itemLayout = (ViewGroup) getChildAt(selectedItem - getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            itemLayout.addView(deleteButton, params);
            isDeleteShown = true;
        }
        return false;
    }

    //构造函数
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyDeleteListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public MyDeleteListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyDeleteListView(Context context) {
        super(context);
    }

    //OnTouch
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (isDeleteShown) {
            itemLayout.removeView(deleteButton);
            deleteButton = null;
            isDeleteShown = false;
            return false;
        } else {
            return gestureDetector.onTouchEvent(event);
        }
    }
}
