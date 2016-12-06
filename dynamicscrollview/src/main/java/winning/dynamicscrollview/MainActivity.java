package winning.dynamicscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll_main = (LinearLayout) findViewById(R.id.ll_main);


        for (int i = 0; i < 10; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.button_layout, null);
            Button btn = (Button) view.findViewById(R.id.btn);
            btn.setText("你好！" + i);
            final int finalI = i;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "btn" + finalI, Toast.LENGTH_SHORT).show();
                }
            });
            ll_main.addView(btn);
        }

    }
}
