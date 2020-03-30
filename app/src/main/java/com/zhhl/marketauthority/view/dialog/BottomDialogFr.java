package com.zhhl.marketauthority.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.bumptech.glide.load.engine.Resource;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.backlog.ApplyUnitResouse;
import com.zhhl.marketauthority.config.UrlConfig;
import com.zhhl.marketauthority.nohttp.NohttpClient;
import com.zhhl.marketauthority.nohttp.listener.HttpListener;
import com.zhhl.marketauthority.util.ToastUtils;
import com.zhhl.marketauthority.util.UntilsTime;

import java.util.Date;

public class BottomDialogFr extends DialogFragment {

    private View frView;
    private TextView et_updatetime;
    private TextView submit;
    private EditText et_idea;
    private RadioGroup rg;
    private Context context;
    private String ps_state;
    private String n_b_id;
    private Window window;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 去掉默认的标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        frView = inflater.inflate(R.layout.dialog_fr_bottom, null);
        init();
        return frView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void init() {
        et_updatetime = frView.findViewById(R.id.et_updatetime);
        rg = frView.findViewById(R.id.rg);
        submit = frView.findViewById(R.id.submit);
        et_idea = frView.findViewById(R.id.et_idea);
        et_updatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.et_updatetime:
                        TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
                            @Override
                            public void onTimeSelect(Date date, View v) {
                                String time = UntilsTime.getTime(date);
                                et_updatetime.setText(time);

                            }
                        }).setType(new boolean[]{true, true, true, true, true, true}).isDialog(true).build();
                        Dialog dialog = pvTime.getDialog();
                        Window window = dialog.getWindow();
                        window.setWindowAnimations(R.style.bottomDialog);
                        window.setBackgroundDrawableResource(android.R.color.transparent);
                        window.getDecorView().setPadding(0,0,0,0);
                        WindowManager.LayoutParams params = window.getAttributes();
                        params.gravity = Gravity.BOTTOM;
                        // 如果不设置宽度,那么即使你在布局中设置宽度为 match_parent 也不会起作用
                        params.width = getResources().getDisplayMetrics().widthPixels;
                        window.setAttributes(params);
                        pvTime.show();
                        break;
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.all:
                        ps_state = "0";
                        break;
                    case R.id.type_1:
                        ps_state = "1";
                        break;
                    case R.id.type_2:
                        ps_state = "2";
                        break;
                    case R.id.type_3:
                        ps_state = "3";
                        break;
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(ps_state)){
                String psyj = et_idea.getText().toString();
                String time = et_updatetime.getText().toString();
                NohttpClient client = new NohttpClient(getActivity());
                Request<String> request = NoHttp.createStringRequest(UrlConfig.PAHT_DB_PJ, RequestMethod.POST);
                request.add("XCPSZT",ps_state);
                request.add("XCPSYJ",psyj);
                request.add("ZGSJ",time);
                request.add("N_B_ID",n_b_id);
                client.request(0,request,httpListener,true,true);
            }else{
                    ToastUtils.show(getContext(),"请选择评审状态");
                }
            }
        });

    }

    private HttpListener<String> httpListener = new HttpListener<String>() {

        @Override
        public void onSucceed(int what, Response<String> response) {
            System.out.println("评审返回值："+response.get());
            ToastUtils.show(getContext(),"评审完成");
            getActivity().finish();
        }

        @Override
        public void onFailed(int what, Response<String> response) {

        }
    };

    @Override
    public void onStart() {
        super.onStart();
        // 下面这些设置必须在此方法(onStart())中才有效

        window = getDialog().getWindow();
        // 如果不设置这句代码, 那么弹框就会与四边都有一定的距离
        window.setBackgroundDrawableResource(android.R.color.transparent);
        // 设置动画
        window.setWindowAnimations(R.style.bottomDialog);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        // 如果不设置宽度,那么即使你在布局中设置宽度为 match_parent 也不会起作用
        params.width = getResources().getDisplayMetrics().widthPixels;
        window.setAttributes(params);
    }
    public void setN_B_ID(String n_b_id){
        this.n_b_id = n_b_id;
    }
}
