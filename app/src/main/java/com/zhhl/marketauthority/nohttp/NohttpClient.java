package com.zhhl.marketauthority.nohttp;

import android.app.Activity;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.zhhl.marketauthority.nohttp.listener.HttpListener;
import com.zhhl.marketauthority.nohttp.listener.HttpResponseListener;

/**
 * Created by JunpLi on 2017/12/13.
 */

public class NohttpClient {
    /**
     * 用来标记取消。
     */
    private Object object = new Object();

    /**
     * 请求队列。
     */
    private RequestQueue mQueue;

    private Activity mActivity;

    public NohttpClient(Activity mActivity){
        this.mActivity = mActivity;
        // 初始化请求队列，传入的参数是请求并发值。
        mQueue = NoHttp.newRequestQueue(1);
    }

    public <T> void request(int what, Request<T> request, HttpListener<T> callback,
                            boolean canCancel, boolean isLoading) {
        request.setCancelSign(object);
        mQueue.add(what, request, new HttpResponseListener<>(mActivity, request, callback, canCancel, isLoading));
    }
}
