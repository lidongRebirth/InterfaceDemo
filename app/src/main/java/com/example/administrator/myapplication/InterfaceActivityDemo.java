package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 测试网络回调是怎么一回事
 * 体验MVP模式
 * 体验OKGo网络请求框架的使用
 */
public class InterfaceActivityDemo extends AppCompatActivity {

    @BindView(R.id.text_content)
    TextView textContent;
    @BindView(R.id.btn)
    Button btn;
    private static final String TAG = "InterfaceActivityDemo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_demo);
        ButterKnife.bind(this);     //初始化
//        textContent = findViewById(R.id.text_content);
//        btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getData();
//            }
//        });
    }

    @OnClick(R.id.btn)
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "点击", Toast.LENGTH_SHORT).show();
        getData();

    }

    private String url = "http://www.wanandroid.com/tools/mockapi/10592/tzhapisms";

    public void getData() {
        OkGo.<DataBean>get(url)
                .execute(new Callback<DataBean>() {
                    @Override
                    public void onStart(Request<DataBean, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<DataBean> response) {
//                        Gson gson = new Gson();
//                        DataBean data= gson.fromJson(String.valueOf(response.body()), DataBean.class);
////                        textContent.setText(String.valueOf(response.body()));
//
//                        textContent.setText(data.getMessage());
                        if (response != null && response.body() != null) {
//                            Toast.makeText(getApplicationContext(), "response为空", Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"不为空",Toast.LENGTH_SHORT).show();
                            textContent.setText(response.body().getMessage());

                        } else {
//                            textContent.setText(response.body().getMessage());
                            Toast.makeText(getApplicationContext(), "response为空", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCacheSuccess(Response<DataBean> response) {

                    }

                    @Override
                    public void onError(Response<DataBean> response) {

                        Log.i(TAG, "onError: " + response.body().toString());
                    }

                    @Override
                    public void onFinish() {

                    }

                    @Override
                    public void uploadProgress(Progress progress) {

                    }

                    @Override
                    public void downloadProgress(Progress progress) {

                    }

                    @Override
                    public DataBean convertResponse(okhttp3.Response response) throws Throwable {
                        return null;
                    }
                });
    }
}
