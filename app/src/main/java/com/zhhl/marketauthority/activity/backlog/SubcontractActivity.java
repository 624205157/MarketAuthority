package com.zhhl.marketauthority.activity.backlog;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;

import butterknife.BindView;

//分包，外协情况
public class

 SubcontractActivity extends BaseActivity {

    @BindView(R.id.et_code)
    EditText et_code;//统一社会信用代码/注册号
    @BindView(R.id.et_sub_unit)
    EditText et_sub_unit;//分包、外协单位名称
    @BindView(R.id.et_type)
    EditText et_type;//类型
    @BindView(R.id.et_device_model)
    EditText et_device_model;//分包、外协项目
    @BindView(R.id.et_updatetime)
    EditText et_updatetime;//评审时间
    @BindView(R.id.et_idea)
    EditText et_idea;//评审意见
    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;//合格
    @BindView(R.id.unregular)
    RadioButton unregular;//不合格
    @BindView(R.id.submit)
    TextView submit;//提交
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    @Override
    protected int setContentView() {
        return R.layout.activity_subcontract;

    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("分包、外协情况");
        change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSate(markBool);
//                mAdapter.setToChange(true);
            }
        });
        init();
        setData();
    }

    private void changeSate(Boolean bool) {
        et_code.setEnabled(bool);
        et_code.setBackground(ContextCompat.getDrawable(SubcontractActivity.this,R.drawable.background_arc_3));
        et_sub_unit.setEnabled(bool);
        et_sub_unit.setBackground(ContextCompat.getDrawable(SubcontractActivity.this,R.drawable.background_arc_3));
        et_type.setEnabled(bool);
        et_type.setBackground(ContextCompat.getDrawable(SubcontractActivity.this,R.drawable.background_arc_3));
        et_device_model.setEnabled(bool);
        et_device_model.setBackground(ContextCompat.getDrawable(SubcontractActivity.this,R.drawable.background_arc_3));
        et_updatetime.setEnabled(bool);
        et_updatetime.setBackground(ContextCompat.getDrawable(SubcontractActivity.this,R.drawable.background_arc_3));
        et_idea.setEnabled(bool);
        et_idea.setBackground(ContextCompat.getDrawable(SubcontractActivity.this,R.drawable.background_arc_3));


    }

    private void init() {
        
    }

    private void setData() {
        
    }
}
