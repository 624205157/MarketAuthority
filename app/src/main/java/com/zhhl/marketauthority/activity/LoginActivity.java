package com.zhhl.marketauthority.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.czy.commonlib.activity.BaseActivity;
import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.bean.LoginResult;
import com.czy.commonlib.UrlConfig;
import com.czy.commonlib.nohttp.listener.HttpListener;
import com.czy.commonlib.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈泽宇 on 2019/12/11.
 * Describe:
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.id_card)
    EditText id_card;
    @BindView(R.id.et_phone)
    EditText et_phone;

    @Override
    protected int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate() {
        setTitleText("现场评审");
        ImageView back = findViewById(R.id.back);
        back.setVisibility(View.INVISIBLE);
        ImageView change; change = findViewById(R.id.change);
        change.setVisibility(View.INVISIBLE);
    }
    @OnClick({R.id.login,})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.login:
                logoin();
                break;
        }
    }

    private void logoin() {
        String cardNum = id_card.getText().toString().trim();
        String et_phoneNum = et_phone.getText().toString().trim();
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PAHT_LOGIN, RequestMethod.POST);
        request.add("idcard",cardNum);
        request.add("telphone",et_phoneNum);
        request(0,request,httpListener,true,true);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            System.out.println("登录数据："+response.get());
            if (what == 0) {
                Gson gson = new Gson();
                LoginResult loginResult = gson.fromJson(response.get(), LoginResult.class);
                if (loginResult.getFlag().equals("1")){
                    startActivity(new Intent(mContext, TSMainActivity.class));
//                    Intent intent = new Intent(mContext, PreviewReport.class);
//                    startActivity(intent);
                }else{
                    ToastUtils.show(mContext,loginResult.getMsg());
                }
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(mContext,response.getException().toString());
        }

    };
}
