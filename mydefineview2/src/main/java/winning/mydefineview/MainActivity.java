package winning.mydefineview;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        vp_main.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view;
                if (position == 0) {
                    view = View.inflate(MainActivity.this, R.layout.sec_vp_layout, null);
                    MyVpVp vp = (MyVpVp) view.findViewById(R.id.vp_sec);
                    vp.setAdapter(new PagerAdapter() {
                        @Override
                        public int getCount() {
                            return 3;
                        }

                        @Override
                        public boolean isViewFromObject(View view, Object object) {
                            return view == object;
                        }

                        @Override
                        public Object instantiateItem(ViewGroup container, int position) {
                            TextView tv = new TextView(MainActivity.this);
                            tv.setText("Sec" + position);
                            container.addView(tv);
                            return tv;
                        }

                        @Override
                        public void destroyItem(ViewGroup container, int position, Object object) {
                            container.removeView((View) object);
                        }
                    });
                } else {
                    TextView tv = new TextView(MainActivity.this);
                    tv.setText("vp" + position);
                    view = tv;
                }

                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }
}
