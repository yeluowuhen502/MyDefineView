package winning.inflatertest.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jiang on 2016/12/7.
 */

public class CounterView extends View {
    public CounterView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {

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
}
