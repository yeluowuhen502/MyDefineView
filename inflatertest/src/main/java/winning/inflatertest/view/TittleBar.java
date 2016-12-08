package winning.inflatertest.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import winning.inflatertest.R;

/**
 * Created by Jiang on 2016/12/8.
 */

public class TittleBar extends FrameLayout {
    private ImageView iv;
    private TextView tv;
    private OnTittleClickListener mTittleClickListener;

    public interface OnTittleClickListener {
        public void OnTittleClickListener();
    }

    public void setOnTittleClickLiatener(OnTittleClickListener mTittleClickListener) {
        this.mTittleClickListener = mTittleClickListener;
    }

    public TittleBar(Context context) {
        super(context);
        initViews(context);
    }

    private void initViews(final Context context) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.tittle_layout, this);
        iv = (ImageView) findViewById(R.id.iv_tittle);
        tv = (TextView) findViewById(R.id.tv_tittle);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mTittleClickListener.OnTittleClickListener();

            }
        });
    }

    public void setTittle(String tittle) {
        tv.setText(tittle);
    }

    public TittleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public TittleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TittleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(context);
    }


}
