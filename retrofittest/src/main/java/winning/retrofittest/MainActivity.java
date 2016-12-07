package winning.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<ReturnBean> call = userBiz.getReturn(1);
        call.enqueue(new Callback<ReturnBean>() {
            @Override
            public void onResponse(Call<ReturnBean> call, Response<ReturnBean> response) {
                Log.e("infoooo", "normalGet:" + response.body() + "");
            }

            @Override
            public void onFailure(Call<ReturnBean> call, Throwable t) {
                Log.e("infoooo", "normalGet:" + t.toString() + "");
            }
        });
    }

    public interface IUserBiz {
        @GET("all/20/{page}")
        Call<ReturnBean> getReturn(@Path("page") int page);
    }
}
