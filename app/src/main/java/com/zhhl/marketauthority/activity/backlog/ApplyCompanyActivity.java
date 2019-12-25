package com.zhhl.marketauthority.activity.backlog;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
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
        setData();
    }

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

    private void setData() {
        et_unit.setText("长春市宏日新能源有限责任公司");
        et_legal.setText("洪浩");
        et_createtime.setText("2010年02月03日");
        et_assets.setText("8000万元");
        et_funds.setText("1994.36 万元");
        et_address.setText("吉林省长春市经济开发区兴隆综合保税区联检大楼405-6室");
        et_industry.setText("信息安全技术领域内的技术开发，电子计算机及计算机网络"+
                "科技技术开发、技术服务，经销计算机软件硬件及辅助设备" +
                "、文化用品、办公用品、机械设备，建筑装饰工程施工，货" +
                "物及技术进出口，计算机系统集成服务，建筑智能化工程、" +
                "网络综合布线工程，信息安全工程、安防监控工程设计、施" +
                "工（依法须经批准的项目，经相关部门批准后方可开展经营" +
                "活动）");
        et_code.setText("91220101MA14DLR10L");
        et_ratify.setText("220123");
        et_type.setText("内资企业");
        et_phone.setText("13500889232");
        et_cardNum.setText("220203196510290334");
        et_proxy_cardNum.setText("220203196810090354");
        et_proxy_name.setText("张凤阁");
        et_proxy_phone.setText("13800881202");

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
