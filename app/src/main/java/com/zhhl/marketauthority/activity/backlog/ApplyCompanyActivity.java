package com.zhhl.marketauthority.activity.backlog;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BacklogActivity;
import com.zhhl.marketauthority.activity.BaseActivity;
import com.zhhl.marketauthority.bean.BacklogBean;
import com.zhhl.marketauthority.config.UrlConfig;
import com.zhhl.marketauthority.nohttp.listener.HttpListener;
import com.zhhl.marketauthority.util.GsonUtil;
import com.zhhl.marketauthority.util.ToastUtils;
import com.zhhl.marketauthority.util.UntilsTime;

import java.util.Date;

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
    @Override
    protected int setContentView() {
        return R.layout.activity_applycompany;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("申请单位基本信息");
        change = addChange();
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

        //Constants.URL_NOHTTP_POST
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_COMMON, RequestMethod.POST);
        request.add("N_L_ID","4cbd25f2d8874c2b9c69c6ff747f2573");
        request.add("N_B_ID","2dcb6349acc545c1a92d6c9253d89547");
        request.add("N_TYPE","1");
        request(0,request,httpListener,true,true);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            BacklogBean backlogBean = GsonUtil.GsonToBean(response.get(), BacklogBean.class);
            if (backlogBean!=null){
                setData(backlogBean);
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(mContext,"请求失败");
        }
    };
    @OnClick({R.id.et_createtime})
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
        }

    }
    //设置修改状态背景
    private void changeSate() {
        change.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.VISIBLE);
        et_unit.setEnabled(true);
        et_legal.setEnabled(true);
        et_createtime.setEnabled(true);
        et_assets.setEnabled(true);
        et_funds.setEnabled(true);
        et_address.setEnabled(true);
        et_industry.setFocusable(true);
        et_industry.setCursorVisible(true);
        et_industry.setEnabled(true);
        et_industry.setFocusableInTouchMode(true);
        et_code.setEnabled(true);
        et_ratify.setEnabled(true);
        et_type.setEnabled(true);
        et_phone.setEnabled(true);
        et_cardNum.setEnabled(true);
        et_proxy_cardNum.setEnabled(true);
        et_proxy_name.setEnabled(true);
        et_proxy_phone.setEnabled(true);
        et_unit.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_legal.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_createtime.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_assets.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_funds.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_address.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_industry.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_code.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_ratify.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_type.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_phone.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_cardNum.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_proxy_cardNum.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_proxy_name.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
        et_proxy_phone.setBackground(ContextCompat.getDrawable(ApplyCompanyActivity.this,R.drawable.background_arc_3));
    }

    //设置回显数据
    private void setData(BacklogBean backlogBean) {

        BacklogBean.ObjBean.ResBean bean = backlogBean.getObj().getRes();
        et_unit.setText(bean.getV_C_NAME());
        et_legal.setText(bean.getV_LEGAL_PERSON());
        et_createtime.setText(bean.getD_CREATE_DATE());
        et_assets.setText(bean.getFIXED_ASSETS());
        et_funds.setText(bean.getREGISTERED_CAPITAL());
        et_address.setText(bean.getV_ADDRESS());
        et_industry.setText(bean.getV_TRADE());
        et_code.setText(bean.getV_CREDIT_CODE());
        et_ratify.setText(bean.getV_APPROVE());
        et_type.setText(bean.getV_CONPANY_TYPE());
        et_phone.setText(bean.getV_PERSON_PHONE());
        et_cardNum.setText("");//法人身份证
        et_proxy_cardNum.setText("220203196810090354");//代办人身份证
        et_proxy_name.setText("张凤阁");//代办人姓名
        et_proxy_phone.setText("13800881202");//代办人电话

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
