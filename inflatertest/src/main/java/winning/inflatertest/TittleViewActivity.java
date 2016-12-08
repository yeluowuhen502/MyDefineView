package winning.inflatertest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import winning.inflatertest.view.TittleBar;

public class TittleViewActivity extends Activity {
    private TittleBar tittleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tittle_view);
        tittleBar = (TittleBar) findViewById(R.id.tittle_bar);
        tittleBar.setTittle("田总你好！");
        tittleBar.setOnTittleClickLiatener(new TittleBar.OnTittleClickListener() {
            @Override
            public void OnTittleClickListener() {
                Toast.makeText(TittleViewActivity.this, "返回", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
