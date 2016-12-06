package winning.inflatertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll_mian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_mian = (LinearLayout) findViewById(R.id.ll_main);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View btn = mInflater.inflate(R.layout.button_layout, null);
        ll_mian.addView(btn);
    }
}
