package com.example.administrator.myapplication;

import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import butterknife.BindView;

/**
 * 具体的网络操作
 */
public class Model {

    @BindView(R.id.text_content)
    TextView textView;
    private String url = "http://www.wanandroid.com/tools/mockapi/10592/tzhapisms";
    public void getData() {
        OkGo.<DataBean>get(url)
                .execute(new Callback<DataBean>() {
                    @Override
                    public void onStart(Request<DataBean, ? extends Request> request) {

                    }
                    @Override
                    public void onSuccess(Response<DataBean> response) {
                        textView.setText(response.toString());
                    }
                    @Override
                    public void onCacheSuccess(Response<DataBean> response) {

                    }
                    @Override
                    public void onError(Response<DataBean> response) {

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
