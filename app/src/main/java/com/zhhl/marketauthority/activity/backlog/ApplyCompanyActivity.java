package com.zhhl.marketauthority.activity.backlog;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.czy.commonlib.activity.BaseActivity;
import com.zhhl.marketauthority.bean.ApplyCompanyBean;
import com.czy.commonlib.UrlConfig;
import com.czy.commonlib.nohttp.listener.HttpListener;
import com.czy.commonlib.util.GsonUtil;
import com.czy.commonlib.util.ToastUtils;
import com.czy.commonlib.util.UntilsTime;
import com.czy.commonlib.view.dialog.RemindDialog;

import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

//申请单位基本信息
public class ApplyCompanyActivity extends BaseActivity {
    @BindView(R.id.submit)
    TextView submit;
    @BindView(R.id.et_unit)
    EditText et_unit;//申请单位
    @BindView(R.id.et_legal)
    EditText et_legal;//法定代表人
    @BindView(R.id.et_createtime)
    TextView et_createtime;//成立日期
    @BindView(R.id.et_assets)
    EditText et_assets;//固定资产
    @BindView(R.id.et_funds)
    EditText et_funds;//注册资金
    @BindView(R.id.et_address)
    EditText et_address;//单位地址
    @BindView(R.id.et_make_address)
    EditText et_make_address;//制造地址
    @BindView(R.id.et_industry)
    EditText et_industry;//所属行业
    @BindView(R.id.et_code)
    EditText et_code;//统一社会信用代码
    @BindView(R.id.et_ratify)
    EditText et_ratify;//批准成立机关
    @BindView(R.id.et_type)
    EditText et_type;//经济类型
    @BindView(R.id.et_phone)
    EditText et_phone;//法人电话
    @BindView(R.id.et_cardNum)
    EditText et_cardNum;//法人身份证
    @BindView(R.id.et_proxy_cardNum)
    EditText et_proxy_cardNum;//代办人身份证
    @BindView(R.id.et_proxy_name)
    EditText et_proxy_name;//代办人姓名
    @BindView(R.id.et_proxy_phone)
    EditText et_proxy_phone;//代办人电话
    private ImageView back;
    private ImageView change;
    private Context mContext = ApplyCompanyActivity.this;
    ApplyCompanyBean backlogBean;
    @Override
    protected int setContentView() {
        return R.layout.activity_applycompany;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("申请单位基本信息");
        change = addChange();
        change.setVisibility(View.VISIBLE);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSate();
//                mAdapter.setToChange(true);
            }
        });
        getData();
    }
    private void getData() {
        Intent intent = getIntent();
        //Constants.URL_NOHTTP_POST
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_COMMON, RequestMethod.POST);
        request.add("N_L_ID",intent.getStringExtra("N_L_ID"));
        request.add("N_B_ID",intent.getStringExtra("N_B_ID"));
        request.add("N_TYPE","1");
        request(0,request,httpListener,true,true);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            if (what==0){
             backlogBean = GsonUtil.GsonToBean(response.get(), ApplyCompanyBean.class);
            if (backlogBean!=null){
                setData();
            }
            }else if (what==1){
                JsonElement jsonElement = new JsonParser().parse(response.get());
                String code = jsonElement.getAsJsonObject().get("code").getAsString();
                String msg = jsonElement.getAsJsonObject().get("msg").getAsString();
                RemindDialog remindDialog = new RemindDialog(mContext,R.style.MyDialog);
                remindDialog.setMessage(msg);
                remindDialog.setYesOnclickListener("确定", new RemindDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        ApplyCompanyActivity.this.finish();
                    }
                });
                remindDialog.setNoOnclickListener("取消", new RemindDialog.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {
                        remindDialog.dismiss();
                    }
                });
                remindDialog.show();
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(mContext,"请求失败");
        }
    };
    @OnClick({R.id.et_createtime,R.id.submit})
    public void onViewClick(View view){
        switch (view.getId()) {
            case R.id.et_createtime:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(ApplyCompanyActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = UntilsTime.getTime(date);
                        et_createtime.setText(time);

                    }
                }).setType(new boolean[]{true, true, true, true, true, true}).build();
                pvTime.show();
                break;
            case R.id.submit:
                uploadData();
                break;
        }

    }

    private void uploadData() {
        submit.setVisibility(View.INVISIBLE);
        change.setVisibility(View.VISIBLE);
        String make_address = et_make_address.getText().toString().trim();
        String n_c_id = backlogBean.getObj().getRes().getN_C_ID();
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_UPLOAD_DATA, RequestMethod.POST);
        Map<String,Object> map = new HashMap<>();
        map.put("id",n_c_id);//主键表ID
        map.put("tjlx","1");//提交类型
//        map.put("PSZT","1");//评审状态
//        map.put("PSZT","1");//评审时间取服务器系统时间
        map.put("v_make_adress",make_address);//制造地址
        request.add(map);
        request(1,request,httpListener,true,true);


    }

    private HttpListener<JSONObject> objectListener = new HttpListener<JSONObject>() {
        @Override
        public void onSucceed(int what, Response<JSONObject> response) {

            JSONObject jsonObject = response.get();
            System.out.println("请求结果："+jsonObject.toString());

        }

        @Override
        public void onFailed(int what, Response<JSONObject> response) {

        }
    };
    //设置修改状态背景
    private void changeSate() {
        change.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.VISIBLE);
        et_make_address.setEnabled(true);
        et_make_address.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
    }

    //设置回显数据
    private void setData() {

        ApplyCompanyBean.ObjBean.ResBean bean = backlogBean.getObj().getRes();
        et_unit.setText(bean.getV_C_NAME());
        et_legal.setText(bean.getV_LEGAL_PERSON());
        et_createtime.setText(bean.getD_CREATE_DATE());
        et_assets.setText(bean.getFIXED_ASSETS());
        et_funds.setText(bean.getREGISTERED_CAPITAL());
        et_address.setText(bean.getV_ADDRESS());
        et_make_address.setText(bean.getV_MAKE_ADRESS());
        et_industry.setText(bean.getV_TRADE());
        et_code.setText(bean.getV_CREDIT_CODE());
        et_ratify.setText(bean.getV_APPROVE());
        if (bean.getV_CONPANY_TYPE().equals("1")){
            et_type.setText("内资企业");
        }else{
            et_type.setText("内资企业");
        }
        et_phone.setText(bean.getV_PERSON_PHONE());
        et_cardNum.setText(bean.getV_FR_SFZ());//法人身份证
        et_proxy_cardNum.setText(bean.getV_DBR_SFZ());//代办人身份证
        et_proxy_name.setText(bean.getV_DBR());//代办人姓名
        et_proxy_phone.setText(bean.getV_DBR_TEL());//代办人电话

    }
    protected void addBack() {
        back = findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
