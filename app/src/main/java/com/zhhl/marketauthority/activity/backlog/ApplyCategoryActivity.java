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
public class ApplyCategoryActivity extends BaseActivity {
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
    private ImageView back;
    private ImageView change;
    @Override
    protected int setContentView() {
        return R.layout.activity_applycateory;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("申请许可类别");
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
                TimePickerView pvTime = new TimePickerBuilder(ApplyCategoryActivity.this, new OnTimeSelectListener() {
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
        et_unit.setBackground(ContextCompat.getDrawable(ApplyCategoryActivity.this,R.drawable.background_arc_3));
        et_legal.setBackground(ContextCompat.getDrawable(ApplyCategoryActivity.this,R.drawable.background_arc_3));
        et_createtime.setBackground(ContextCompat.getDrawable(ApplyCategoryActivity.this,R.drawable.background_arc_3));
        et_assets.setBackground(ContextCompat.getDrawable(ApplyCategoryActivity.this,R.drawable.background_arc_3));
        et_funds.setBackground(ContextCompat.getDrawable(ApplyCategoryActivity.this,R.drawable.background_arc_3));
        et_address.setBackground(ContextCompat.getDrawable(ApplyCategoryActivity.this,R.drawable.background_arc_3));
    }

    private void setData() {
        et_unit.setText("锅炉制造");
        et_legal.setText("锅炉");
        et_createtime.setText("锅炉B级");
        et_assets.setText("无");
        et_funds.setText("吉大正元");
        et_address.setText("无");

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
